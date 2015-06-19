package com.ftfl.nasser.androidevent;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener, OnLongClickListener, OnFocusChangeListener, OnTouchListener {

	Button mBtnTest = null;
	Button mBtnTouch = null;
	EditText mEtOne = null;
	EditText mEtTwo = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mBtnTest = (Button) findViewById(R.id.buttonTest);
		mBtnTest.setOnClickListener(this);
		mBtnTest.setOnLongClickListener(this);
		
		mBtnTouch = (Button) findViewById(R.id.buttonTouch);
		mBtnTouch.setOnTouchListener(this);
		
		mEtOne = (EditText) findViewById(R.id.editTextOne);
		mEtTwo = (EditText) findViewById(R.id.editTextTwo);
		
		mEtOne.setOnFocusChangeListener(this);
		mEtTwo.setOnFocusChangeListener(this);
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

	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		// TODO Auto-generated method stub
		if(hasFocus)
		{
			switch(v.getId())
			{
			case R.id.editTextOne:
				Toast.makeText(getApplicationContext(), "Focus Changed to Edit text One", Toast.LENGTH_SHORT).show();
				break;
			case R.id.editTextTwo:
				Toast.makeText(getApplicationContext(), "Focus Changed to Edit text Two", Toast.LENGTH_SHORT).show();
				break;
			}
		}
		
	}

	@Override
	public boolean onLongClick(View v) {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(), "Long Clicked", Toast.LENGTH_LONG).show();
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		Toast.makeText(getApplicationContext(), "Button Clicked", Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		switch(event.getAction() & MotionEvent.ACTION_MASK)
		{
		case MotionEvent.ACTION_UP:
			Toast.makeText(getApplicationContext(), "Button Touched", Toast.LENGTH_LONG).show();
			break;
		}
		return true;
	}
}
