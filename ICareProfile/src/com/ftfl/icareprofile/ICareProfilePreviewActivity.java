package com.ftfl.icareprofile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.ftfl.icareprofile.database.ICareDataSource;
import com.ftfl.icareprofile.utill.ICareProfile;

public class ICareProfilePreviewActivity extends ActionBarActivity {
	TextView mTvName = null;
	TextView mTvFathersName = null;
	TextView mTvMothersName = null;
	TextView mTvAge = null;

	String mStrProfileID = null;
	long mProfileId = 0;
	ICareProfile mUpdateProfile = null;
	ICareDataSource mDataSource = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_icare_profile_preview);
		
		/*
		 * set view
		 */
		mTvName = (TextView) findViewById(R.id.db_name);
		mTvFathersName = (TextView) findViewById(R.id.db_fathers_name);
		mTvMothersName = (TextView) findViewById(R.id.db_mothers_name);
		mTvAge = (TextView) findViewById(R.id.db_age);
	

		/*
		 * Get data from intent
		 */
		Intent mIntent = getIntent();
		mStrProfileID = mIntent.getStringExtra("profileId");
		mProfileId = Long.parseLong(mStrProfileID);

		/*
		 * view text
		 */
		showText(mProfileId);
	}
	
	public void showText(long eProfileId) {

		/*
		 * get the profile which include all data from database according
		 * profileId of the clicked item.
		 */
		mDataSource = new ICareDataSource(this);
		mUpdateProfile = mDataSource.updateProfileData(mProfileId);
		String mName = mUpdateProfile.getName();
		String mFathersName = mUpdateProfile.getFatherName();
		String mMothersName = mUpdateProfile.getMotherName();
		String mAge = mUpdateProfile.getAge();

		/*
		 * Set the data of database to the TextView
		 */

		mTvName.setText(mName);
		mTvFathersName.setText(mFathersName);
		mTvMothersName.setText(mMothersName);
		mTvAge.setText(mAge);


	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.icare_profile_preview, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.edit_profile:
			Intent mEditIntent = new Intent(getApplicationContext(),
					ICareCreateProfileActivity.class);
			mEditIntent.putExtra("profileId", mStrProfileID);
			// startActivity(mEditIntent);
			startActivityForResult(mEditIntent, 1);

			return true;
		case R.id.delete_profile:
			mDataSource = new ICareDataSource(this);
			mDataSource.deleteData(mProfileId);
			finish();

			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}
	

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 1) {
			if (resultCode == Activity.RESULT_OK) {
				Bundle b = data.getExtras();
				if (b != null) {
					mStrProfileID = (String) b.getSerializable("profileID");
					mProfileId = Long.parseLong(mStrProfileID);
					mDataSource = new ICareDataSource(this);

					mUpdateProfile = mDataSource.updateProfileData(mProfileId);
					showText(mProfileId);
				}
			} else if (resultCode == 0) {
				System.out.println("RESULT CANCELLED");
			}
		}
	}
}
