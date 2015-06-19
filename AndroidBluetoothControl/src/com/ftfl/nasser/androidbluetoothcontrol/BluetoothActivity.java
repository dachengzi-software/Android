package com.ftfl.nasser.androidbluetoothcontrol;

import android.support.v7.app.ActionBarActivity;
import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class BluetoothActivity extends ActionBarActivity {

	ToggleButton mBtnBluetooth = null;
	BluetoothAdapter mBluetoothAdapter = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bluetooth);
		
		mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		
		mBtnBluetooth = (ToggleButton) findViewById(R.id.btnBluetooth);
		mBtnBluetooth.setChecked(mBluetoothAdapter.isEnabled());
		
		mBtnBluetooth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				
				if(isChecked)
				{
					mBluetoothAdapter.enable();
					Toast.makeText(getApplicationContext(), "Bluetooth is Enabled.", Toast.LENGTH_SHORT).show();
				}
				
				else
				{
					mBluetoothAdapter.disable();
					Toast.makeText(getApplicationContext(), "Bluetooth is Disabled.", Toast.LENGTH_SHORT).show();
				
				}
				
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bluetooth, menu);
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
