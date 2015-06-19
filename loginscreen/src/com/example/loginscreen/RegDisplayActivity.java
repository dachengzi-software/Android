package com.example.loginscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RegDisplayActivity extends Activity {
	public TextView fullname,email, password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.regdisplay);

		// initialize TextViews
		initializeViews();

		// get the Intent that started this Activity
		Intent in = getIntent();

		// get the Bundle that stores the data of this Activity
		Bundle reg = in.getExtras();

		// getting data from bundle
		String nameString = reg.getString("fullname");
		String emailString = reg.getString("email");
		String passwordString = reg.getString("password");
		

		// show data to layout
		fullname.setText("Fulll Name : " + nameString);
		email.setText("Email : " + emailString);
		password.setText("Password : " + passwordString);
		
	}

	public void initializeViews() {
		fullname = (TextView) findViewById(R.id.fullname);
		email = (TextView) findViewById(R.id.email);
		password = (TextView) findViewById(R.id.password);
		
	}
}
