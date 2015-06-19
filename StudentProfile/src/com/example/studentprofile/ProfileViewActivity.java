package com.example.studentprofile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ProfileViewActivity extends Activity {
	DatabaseHandler db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profileview);
		db = new DatabaseHandler(this);
		Button createProfileButton = (Button) findViewById(R.id.createProfileButton);
		Button viewProfileButton = (Button) findViewById(R.id.ViewProfileButton);
		createProfileButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ProfileViewActivity.this,
						CreateProfileActivity.class);
				startActivity(intent);
				finish();
			}
		});
		viewProfileButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(),db.getProfileCount() , Toast.LENGTH_LONG).show();
				/*Intent intent = new Intent(ProfileViewActivity.this,
						ViewProfileActivity.class);
				startActivity(intent);
				finish();
*/			}
		});


	}

}
