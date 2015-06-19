package com.ftfl.simplewificontrol;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class WifiActivity extends Activity {
	ToggleButton btnWifi = null;
	WifiManager mWifiManager = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wifi);

		mWifiManager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);

		btnWifi = (ToggleButton) findViewById(R.id.btnWifi);
		btnWifi.setChecked(mWifiManager.isWifiEnabled());

		btnWifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				mWifiManager.setWifiEnabled(isChecked);
				if(isChecked)
				{
					Toast.makeText(getApplicationContext(), "WiFi is Enabled.", Toast.LENGTH_SHORT).show();
				}
				else
				{
					Toast.makeText(getApplicationContext(), "WiFi is Disabled.", Toast.LENGTH_SHORT).show();
				}
			}

		});
	}

}
