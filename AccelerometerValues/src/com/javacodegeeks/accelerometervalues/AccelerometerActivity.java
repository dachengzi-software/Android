package com.javacodegeeks.accelerometervalues;

import com.javacodegeeks.androidaccelerometerexample.R;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.TextView;
import android.widget.Toast;

public class AccelerometerActivity extends Activity implements SensorEventListener {

	float mLastX = 0;
	float mLastY = 0;
	float mLastZ = 0;

	SensorManager mSensorManager;
	Sensor mAccelerometer;

	float mDeltaXMax = 0;
	float mDeltaYMax = 0;
	float mDeltaZMax = 0;

	float mDeltaX = 0;
	float mDeltaY = 0;
	float mDeltaZ = 0;

	float mVibrateThreshold = 0;

	TextView tvCurrentX = null;
	TextView tvCurrentY = null;
	TextView tvCurrentZ = null;
	TextView tvMaxX = null;
	TextView tvMaxY = null;
	TextView tvMaxZ = null;

	Vibrator mVibrate;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_accelerometer);
		initializeViews();

		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		if (mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
			// success! we have an accelerometer

			mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
			mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
			mVibrateThreshold = mAccelerometer.getMaximumRange() / 2;
		} else {
			Toast.makeText(getApplicationContext(), "Sorry You do not have Accelerometer..", Toast.LENGTH_SHORT).show();
		}
		
		//initialize vibration
		mVibrate = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);

	}

	public void initializeViews() {
		tvCurrentX = (TextView) findViewById(R.id.currentX);
		tvCurrentY = (TextView) findViewById(R.id.currentY);
		tvCurrentZ = (TextView) findViewById(R.id.currentZ);

		tvMaxX = (TextView) findViewById(R.id.maxX);
		tvMaxY = (TextView) findViewById(R.id.maxY);
		tvMaxZ = (TextView) findViewById(R.id.maxZ);
	}

	//onResume() register the accelerometer for listening the events
	protected void onResume() {
		super.onResume();
		mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
	}

	//onPause() unregister the accelerometer for stop listening the events
	protected void onPause() {
		super.onPause();
		mSensorManager.unregisterListener(this);
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) {

		// clean current values
		displayCleanValues();
		// display the current x,y,z accelerometer values
		displayCurrentValues();
		// display the max x,y,z accelerometer values
		displayMaxValues();

		// get the change of the x,y,z values of the accelerometer
		mDeltaX = Math.abs(mLastX - event.values[0]);
		mDeltaY = Math.abs(mLastY - event.values[1]);
		mDeltaZ = Math.abs(mLastZ - event.values[2]);

		// if the change is below 2, it is just plain noise
		if (mDeltaX < 2)
			mDeltaX = 0;
		if (mDeltaY < 2)
			mDeltaY = 0;
		if (mDeltaZ < 2)
			mDeltaZ = 0;

		// set the last know values of x,y,z
		mLastX = event.values[0];
		mLastY = event.values[1];
		mLastZ = event.values[2];

		vibrate();

	}

	// if the change in the accelerometer value is big enough, then vibrate!
	// our threshold is MaxValue/2
	public void vibrate() {
		if ((mDeltaX > mVibrateThreshold) || (mDeltaY > mVibrateThreshold) || (mDeltaZ > mVibrateThreshold)) {
			mVibrate.vibrate(50);
		}
	}

	public void displayCleanValues() {
		tvCurrentX.setText("0.0");
		tvCurrentY.setText("0.0");
		tvCurrentZ.setText("0.0");
	}

	// display the current x,y,z accelerometer values
	public void displayCurrentValues() {
		tvCurrentX.setText(Float.toString(mDeltaX));
		tvCurrentY.setText(Float.toString(mDeltaY));
		tvCurrentZ.setText(Float.toString(mDeltaZ));
	}

	// display the max x,y,z accelerometer values
	public void displayMaxValues() {
		if (mDeltaX > mDeltaXMax) {
			mDeltaXMax = mDeltaX;
			tvMaxX.setText(Float.toString(mDeltaXMax));
		}
		if (mDeltaY > mDeltaYMax) {
			mDeltaYMax = mDeltaY;
			tvMaxY.setText(Float.toString(mDeltaYMax));
		}
		if (mDeltaZ > mDeltaZMax) {
			mDeltaZMax = mDeltaZ;
			tvMaxZ.setText(Float.toString(mDeltaZMax));
		}
	}
}