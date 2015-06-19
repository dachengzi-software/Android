package com.ftfl.login;

import com.ftfl.androidexam.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class LoginShowActivity extends Activity {
	TextView mtEmail = null;
	TextView mtPassword = null;
	String mEmail = "";
	String mPassword = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_show);
		
		mtEmail = (TextView) findViewById(R.id.show_email);
		mtPassword = (TextView) findViewById(R.id.show_password);
		
		Intent mIntent = getIntent();
		mEmail = mIntent.getStringExtra("email");
		mPassword = mIntent.getStringExtra("password");
		
		mtEmail.setText(mEmail);
		mtPassword.setText(mPassword);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login_show, menu);
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
