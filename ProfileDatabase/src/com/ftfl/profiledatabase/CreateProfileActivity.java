package com.ftfl.profiledatabase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ftfl.icareprofile.R;
import com.ftfl.profiledatabase.database.ProfileDataSource;
import com.ftfl.profiledatabase.utill.Profile;
import com.ftfl.profiledatabase.utill.ProfileConstant;

public class CreateProfileActivity extends ActionBarActivity {
	EditText etName = null;
	String mName = "";
	EditText etFatherName = null;
	String mFatherName = "";
	EditText etMotherName = null;
	String mMotherName = "";
	EditText etAge = null;
	String mAge = "";
	Button btnUpdate = null;
	Button btnDelete = null;
	String mActivityImage = "";
	ProfileDataSource profileDS = null;
	String mStrProfileID = null;
	long mProfileId = 0;
	Profile mUpdateProfile = null;
	ProfileDataSource mDataSource = null;
	Toast toast = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_profile);

		// set the text field id to the variable.
		etName = (EditText) findViewById(R.id.tv_name);
		etFatherName = (EditText) findViewById(R.id.et_father_name);
		etMotherName = (EditText) findViewById(R.id.et_mother_name);
		etAge = (EditText) findViewById(R.id.et_age);

		// set button
		btnUpdate = (Button) findViewById(R.id.btnSubmit);
		btnDelete = (Button) findViewById(R.id.btnCancel);

		/*
		 * Get data from intent
		 */

		Intent mIntent = getIntent();
		mStrProfileID = mIntent.getStringExtra(ProfileConstant.PROFILEID);

		if (mStrProfileID != null) {
			mProfileId = Long.parseLong(mStrProfileID);

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

			// set the value of database to the text field.
			etName.setText(name);
			etFatherName.setText(fatherName);
			etMotherName.setText(motherName);
			etAge.setText(age);

			/*
			 * change button name
			 */

			btnUpdate.setText(getString(R.string.update));
		}
	}

	/*
	 * if button click submit, update, delete and cancel will happen.
	 */

	public void myClickHandler(View v) {

		switch (v.getId()) {

		case R.id.btnSubmit:
			// get values form text field
			etName = (EditText) findViewById(R.id.tv_name);
			etFatherName = (EditText) findViewById(R.id.et_father_name);
			etMotherName = (EditText) findViewById(R.id.et_mother_name);
			etAge = (EditText) findViewById(R.id.et_age);

			mName = etName.getText().toString();
			mFatherName = etFatherName.getText().toString();

			mMotherName = etMotherName.getText().toString();
			mAge = etAge.getText().toString();

			// Assign values in the ICareProfile
			Profile profileDataInsert = new Profile();
			profileDataInsert.setName(mName);
			profileDataInsert.setFatherName(mFatherName);
			profileDataInsert.setMotherName(mMotherName);
			profileDataInsert.setAge(mAge);

			/*
			 * if update is needed then update otherwise submit
			 */
			if (mStrProfileID != null) {
				mProfileId = Long.parseLong(mStrProfileID);

				profileDS = new ProfileDataSource(this);

				if (profileDS.updateData(mProfileId, profileDataInsert) == true) {
					toast = Toast.makeText(this,
							getString(R.string.successfullyUpdated),
							Toast.LENGTH_LONG);
					toast.show();

					Intent intent = new Intent();
					intent.putExtra(ProfileConstant.PROFILEIDTWO, mStrProfileID);
					setResult(Activity.RESULT_OK, intent);
					finish();
				} else {
					toast = Toast.makeText(this,
							getString(R.string.notUpdated), Toast.LENGTH_LONG);
					toast.show();
				}
			}

			else {
				profileDS = new ProfileDataSource(this);
				if (profileDS.insert(profileDataInsert) == true) {
					toast = Toast.makeText(this,
							getString(R.string.successfullySubmited),
							Toast.LENGTH_LONG);
					toast.show();
					finish();
				} else {
					toast = Toast
							.makeText(this, getString(R.string.notSubmitted),
									Toast.LENGTH_LONG);
					toast.show();
				}
			}
			break;
		case R.id.btnCancel:
			finish();
			break;
		}
	}
}
