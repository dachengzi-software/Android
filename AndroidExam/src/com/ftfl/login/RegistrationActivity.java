package com.ftfl.login;

import com.ftfl.androidexam.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends Activity implements OnClickListener {
	EditText meFullName = null;
	EditText meEmail = null;
	EditText mePassword = null;
	String mFullName = "";
	String mEmail = "";
	String mPassword = "";
	Button mRegister = null;
	TextView mtLink = null;
	Toast toast;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration);
		
		meFullName = (EditText) findViewById(R.id.reg_fullname);
		meEmail = (EditText) findViewById(R.id.reg_email);
		mePassword = (EditText) findViewById(R.id.reg_password);
		mRegister = (Button) findViewById(R.id.btnRegister);
		mtLink = (TextView) findViewById(R.id.link_to_login);
		mRegister.setOnClickListener(this);
		mtLink.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.registration, menu);
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
	
	/*
	 * This method check is the email address is validate of not.
	 * It takes the string written in the email text field as input.
	 * It return true if email address is valid otherwise return false.
	 */
	public final static boolean isValidEmail(CharSequence target) {
		if (target == null) {
			return false;
		} else {
			return android.util.Patterns.EMAIL_ADDRESS.matcher(target)
					.matches();
		}
	}
	
	/*
	 * This method declare all work if something click.
	 */

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch (v.getId()) {

		case R.id.btnRegister:
			mFullName = meFullName.getText().toString();
			mEmail = meEmail.getText().toString();
			mPassword = mePassword.getText().toString();
			
			if (TextUtils.isEmpty(mFullName)) {
		
				
				meFullName.requestFocus();
				meFullName.setError(Html.fromHtml("<font color='red'>Enter Email Address. </font>"));
			} 
			else if (TextUtils.isEmpty(mEmail)) {
			
				
				meEmail.requestFocus();
				meEmail.setError(Html.fromHtml("<font color='red'>Enter Email Address. </font>"));
			} 
			else if (TextUtils.isEmpty(mPassword)) {
			
				
				mePassword.requestFocus();
				mePassword.setError(Html.fromHtml("<font color='red'>Enter Password. </font>"));
			}
			else {
				
				if(isValidEmail(mEmail))
				{
					Intent mReg = new Intent(getApplicationContext(),
							RegistrationShowActivity.class);
					mReg.putExtra("rfullname", mFullName);
					mReg.putExtra("remail", mEmail);
					mReg.putExtra("rpassword", mPassword);
					startActivity(mReg);
				}
				else{
				
					
					meEmail.requestFocus();
					meEmail.setError(Html.fromHtml("<font color='red'>Enter Valid Email Address. </font>"));
				}
		
			}
			
		
			break;
			
		case R.id.link_to_login:
		
			Intent mRegister = new Intent(getApplicationContext(),
					LoginActivity.class);
	
			startActivity(mRegister);
			finish();
			break;
		}
		
	}
}
