package com.ftfl.profiledatabase;

import com.ftfl.icareprofile.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class ProfileActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
	}

	public void createProfile(View v)
	{
		startActivity(new Intent(ProfileActivity.this,
		 CreateProfileActivity.class));
	}
	
	public void viewProfile(View v)
	{
		startActivity(new Intent(ProfileActivity.this,
				 ProfileListActivity.class));
	}
}
