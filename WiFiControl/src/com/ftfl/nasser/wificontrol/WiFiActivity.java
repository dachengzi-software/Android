package com.ftfl.nasser.wificontrol;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class WiFiActivity extends ActionBarActivity {
	
	ToggleButton mBtnWiFi = null;
	WifiManager mWiFiManager = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wifi);
		
		mWiFiManager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
		mBtnWiFi = (ToggleButton) findViewById(R.id.btnWiFi);
		mBtnWiFi.setChecked(mWiFiManager.isWifiEnabled());
		
		mBtnWiFi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mWiFiManager.setWifiEnabled(isChecked);
				if(isChecked){
					Toast.makeText(getApplicationContext(), "WiFi is Enabled.", Toast.LENGTH_SHORT).show();
				}
				else
					Toast.makeText(getApplicationContext(), "WiFi is Disabled.", Toast.LENGTH_SHORT).show();
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.wi_fi, menu);
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
