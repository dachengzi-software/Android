package com.ftfl.simpleblutoothcontrol;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class BlutoothActivity extends Activity {
	ToggleButton btnBlutooth = null;
	BluetoothAdapter mBluetoothAdapter = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_blutooth);
		mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		btnBlutooth = (ToggleButton) findViewById(R.id.btnBlutooth);
		btnBlutooth.setChecked(mBluetoothAdapter.isEnabled());

		btnBlutooth
				.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						if (isChecked) {
							mBluetoothAdapter.enable();
							Toast.makeText(getApplicationContext(),
									"Bluetooth is Enabled.", Toast.LENGTH_SHORT)
									.show();
						} else {
							mBluetoothAdapter.disable();
							Toast.makeText(getApplicationContext(),
									"Bluetooth is Disabled.",
									Toast.LENGTH_SHORT).show();
						}
					}

				});
	}
}
