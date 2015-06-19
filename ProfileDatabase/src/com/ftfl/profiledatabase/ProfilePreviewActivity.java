package com.ftfl.profiledatabase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.ftfl.icareprofile.R;
import com.ftfl.profiledatabase.database.ProfileDataSource;
import com.ftfl.profiledatabase.utill.Profile;
import com.ftfl.profiledatabase.utill.ProfileConstant;

public class ProfilePreviewActivity extends ActionBarActivity {
	TextView mTvName = null;
	TextView mTvFatherName = null;
	TextView mTvMotherName = null;
	TextView mTvAge = null;
	String mStrProfileID = null;
	long mProfileId = 0;
	Profile mUpdateProfile = null;
	ProfileDataSource mDataSource = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_icare_profile_preview);
		
		/*
		 * set view
		 */
		mTvName = (TextView) findViewById(R.id.show_tv_name);
		mTvFatherName = (TextView) findViewById(R.id.show_father_name);
		mTvMotherName = (TextView) findViewById(R.id.show_mother_name);
		mTvAge = (TextView) findViewById(R.id.show_age);

		/*
		 * Get data from intent
		 */
		Intent mIntent = getIntent();
		mStrProfileID = mIntent.getStringExtra(ProfileConstant.PROFILEID);
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
		mDataSource = new ProfileDataSource(this);
		mUpdateProfile = mDataSource.singleProfileData(mProfileId);
		String name = mUpdateProfile.getName();
		String fatherName = mUpdateProfile.getFatherName();
		String motherName = mUpdateProfile.getMotherName();
		String age = mUpdateProfile.getAge();

		/*
		 * Set the data of database to the TextView
		 */

		mTvName.setText(name);
		mTvFatherName.setText(fatherName);
		mTvMotherName.setText(motherName);
		mTvAge.setText(age);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profile_preview, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.edit_profile:
			Intent mEditIntent = new Intent(getApplicationContext(),
					CreateProfileActivity.class);
			mEditIntent.putExtra(ProfileConstant.PROFILEID, mStrProfileID);
			startActivityForResult(mEditIntent, 1);
			return true;
			
		case R.id.delete_profile:
			mDataSource = new ProfileDataSource(this);
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
					mStrProfileID = (String) b.getSerializable(ProfileConstant.PROFILEIDTWO);
					mProfileId = Long.parseLong(mStrProfileID);
					mDataSource = new ProfileDataSource(this);

					mUpdateProfile = mDataSource.singleProfileData(mProfileId);
					showText(mProfileId);
				}
			} else if (resultCode == 0) {
				System.out.println("RESULT CANCELLED");
			}
		}
	}
}
