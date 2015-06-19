package com.ftfl.nasser.sharedpreferences;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	EditText mEtName = null;
	EditText mEtPhone = null;
	EditText mEtEmail = null;
	
	SharedPreferences mSharedPreferences;
	
	public static final String MyPreference = "MyPrefs";
	public static final String NAME = "nameKey";
	public static final String PHONE = "phoneKey";
	public static final String EMAIL = "emailKey";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mEtName = (EditText) findViewById(R.id.editTextName);
		mEtPhone = (EditText) findViewById(R.id.editTextPhone);
		mEtEmail = (EditText) findViewById(R.id.editTextEmail);
		
		mSharedPreferences = getSharedPreferences(MyPreference, Context.MODE_PRIVATE);
		
		if(mSharedPreferences.contains(NAME))
		{
			mEtName.setText(mSharedPreferences.getString(NAME, ""));
			
		}
		
		if(mSharedPreferences.contains(PHONE))
		{
			mEtPhone.setText(mSharedPreferences.getString(PHONE, ""));
			
		}
		
		if(mSharedPreferences.contains(EMAIL))
		{
			mEtEmail.setText(mSharedPreferences.getString(EMAIL, ""));
			
		}
	}
	
	
	public void performSave(View v)
	{
		String name = mEtName.getText().toString();
		String phone = mEtPhone.getText().toString();
		String email = mEtEmail.getText().toString();
		
		Editor editor = mSharedPreferences.edit();  //Initialize editor
		
		editor.putString(NAME, name);
		editor.putString(PHONE, phone);
		editor.putString(EMAIL, email);
		
		editor.commit();
		
		Toast.makeText(getApplicationContext(), "Data Saved Successfully", Toast.LENGTH_SHORT).show();
	}

}
