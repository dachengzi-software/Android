package com.ftfl.mymeetingplaces;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class HomeActivity extends Activity {
	private InterstitialAd interstitial;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		// Prepare the Interstitial Ad
				interstitial = new InterstitialAd(HomeActivity.this);
				// Insert the Ad Unit ID
				interstitial.setAdUnitId("ca-app-pub-123456789/123456789");
		 
				//Locate the Banner Ad in activity_main.xml
				AdView adView = (AdView) this.findViewById(R.id.adView);
		 
				// Request for Ads
				AdRequest adRequest = new AdRequest.Builder()
		 
				// Add a test device to show Test Ads
				 .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
				 .addTestDevice("CC5F2C72DF2B356BBF0DA198")
						.build();
		 
				// Load ads into Banner Ads
				adView.loadAd(adRequest);
		 
				// Load ads into Interstitial Ads
				interstitial.loadAd(adRequest);
		 
				// Prepare an Interstitial Ad Listener
				interstitial.setAdListener(new AdListener() {
					public void onAdLoaded() {
						// Call displayInterstitial() function
						displayInterstitial();
					}
				});
	}
	public void displayInterstitial() {
		// If Ads are loaded, show Interstitial else show nothing.
		if (interstitial.isLoaded()) {
			interstitial.show();
		}
	}
	
	
	public void performRegister(View v)
	{
		startActivity(new Intent(HomeActivity.this, MeetingPlaceActivity.class));
		finish();
	}
	
	public void performRetrieve(View v)
	{
		startActivity(new Intent(HomeActivity.this, MeetingPlaceListActivity.class));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
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
