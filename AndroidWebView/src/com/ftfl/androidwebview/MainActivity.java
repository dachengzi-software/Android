package com.ftfl.androidwebview;

import org.json.JSONException;
import org.json.JSONObject;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.JavascriptInterface; //latest version from 17

public class MainActivity extends ActionBarActivity {
	
	  private static String PROVIDER="gps";
	  private WebView browser;
	  private LocationManager myLocationManager=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 browser=(WebView)findViewById(R.id.webkit);
		    
		    myLocationManager=(LocationManager)getSystemService(Context.LOCATION_SERVICE);
		    
		    browser.getSettings().setJavaScriptEnabled(true);
		    browser.setWebChromeClient(new WebChromeClient());  // version latest
		    browser.addJavascriptInterface(new Locater(), "locater");
		    browser.loadUrl("file:///android_asset/geoweb2.html");
	}
	
	
	 
	  @Override
	  public void onResume() {
	    super.onResume();
	    myLocationManager.requestLocationUpdates(PROVIDER, 0,
	                                              0,
	                                              onLocation);
	  }
	  
	  @Override
	  public void onPause() {
	    super.onPause();
	    myLocationManager.removeUpdates(onLocation);
	  }
	  
	  LocationListener onLocation=new LocationListener() {
	    public void onLocationChanged(Location location) {
	      StringBuilder buf=new StringBuilder("javascript:whereami(");
	      
	      buf.append(String.valueOf(location.getLatitude()));
	      buf.append(",");
	      buf.append(String.valueOf(location.getLongitude()));
	      buf.append(")");
	      
	      browser.loadUrl(buf.toString());
	    }
	    
	    public void onProviderDisabled(String provider) {
	      // required for interface, not used
	    }
	    
	    public void onProviderEnabled(String provider) {
	      // required for interface, not used
	    }
	    
	    public void onStatusChanged(String provider, int status,
	                                  Bundle extras) {
	      // required for interface, not used
	    }
	  };
	  
	  public class Locater {
		  
		  @JavascriptInterface //latest version
	    public String getLocation() throws JSONException {
	      Location loc=myLocationManager.getLastKnownLocation(PROVIDER);
	      
	      if (loc==null) {
	        return(null);
	      }
	      
	      JSONObject json=new JSONObject();

	      json.put("lat", loc.getLatitude());
	      json.put("lon", loc.getLongitude());
	      
	      return(json.toString());
	    }
	  }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
