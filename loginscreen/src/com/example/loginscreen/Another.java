package com.example.loginscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Another extends Activity {
	public TextView email, password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.another);

		// initialize TextViews
		initializeViews();

		// get the Intent that started this Activity
		Intent in = getIntent();

		// get the Bundle that stores the data of this Activity
		Bundle login = in.getExtras();

		// getting data from bundle
		String emailString = login.getString("email");

		String passwordString = login.getString("password");
		

		// show data to layout
		email.setText("Email : " + emailString);
		password.setText("Password : " + passwordString);
		
	}

	public void initializeViews() {
		email = (TextView) findViewById(R.id.email);
		password = (TextView) findViewById(R.id.password);
		
	}
}
