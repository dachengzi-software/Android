package com.ftfl.icareprofile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ftfl.icareprofile.database.ICareDataSource;
import com.ftfl.icareprofile.utill.ICareProfile;

public class ICareCreateProfileActivity extends ActionBarActivity {
	EditText et_name = null;
	String mName = "";
	EditText et_fathersName = null;
	String mFathersName = "";
	EditText et_mothersName = null;
	String mMothersName = "";
	EditText et_age = null;
	String mAge = "";
	Button update_btn, delete_btn;
	String mActivityImage = "";
	ICareDataSource icareDS = null;
	String mStrProfileID = null;
	long mProfileId = 0;
	ICareProfile mUpdateProfile = null;
	ICareDataSource mDataSource = null;
	long profileId = 0;
	Toast toast = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_icare_create_profile);

		// set the text field id to the variable.
		et_name = (EditText) findViewById(R.id.name);
		et_fathersName = (EditText) findViewById(R.id.fathers_name);
		et_mothersName = (EditText) findViewById(R.id.mothers_name);
		et_age = (EditText) findViewById(R.id.age);

		// set button
		update_btn = (Button) findViewById(R.id.btnSubmit);
		delete_btn = (Button) findViewById(R.id.btnCancel);

		/*
		 * Get data from intent
		 */

		Intent mIntent = getIntent();
		mStrProfileID = mIntent.getStringExtra("profileId");

		if (mStrProfileID != null) {
			mProfileId = Long.parseLong(mStrProfileID);

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

			// set the value of database to the text field.
			et_name.setText(mName);
			et_fathersName.setText(mFathersName);
			et_mothersName.setText(mMothersName);
			et_age.setText(mAge);

			/*
			 * change button name
			 */

			update_btn.setText("Update");

		}
	}
	
	/*
	 * if button click submit, update, delete and cancel will happen.
	 */

	public void myClickHandler(View v) {

		switch (v.getId()) {

		case R.id.btnSubmit:
			// get values form text field
			et_name = (EditText) findViewById(R.id.name);
			et_fathersName = (EditText) findViewById(R.id.fathers_name);
			et_mothersName = (EditText) findViewById(R.id.mothers_name);
			et_age = (EditText) findViewById(R.id.age);


			mName = et_name.getText().toString();
			mFathersName = et_fathersName.getText().toString();

			mMothersName = et_mothersName.getText().toString();
			mAge = et_age.getText().toString();
	

			// Assign values in the ICareProfile
			ICareProfile profileDataInsert = new ICareProfile();
			profileDataInsert.setName(mName);
			profileDataInsert.setFatherName(mFathersName);
			profileDataInsert.setMotherName(mMothersName);
			profileDataInsert.setAge(mAge);


			/*
			 * if update is needed then update otherwise submit
			 */
			if (mStrProfileID != null) {
				profileId = Long.parseLong(mStrProfileID);

				icareDS = new ICareDataSource(this);

				if (icareDS.updateData(profileId, profileDataInsert) == true) {
					toast = Toast.makeText(this, "Successfully Updated.",
							Toast.LENGTH_LONG);
					toast.show();

					Intent intent = new Intent();
					intent.putExtra("profileID", mStrProfileID);
					setResult(Activity.RESULT_OK, intent);
					finish();

					// startActivity(new Intent(ICareNewProfileActivity.this,
					// ICareProfilePreviewActivity.class));
					// finish();
				} else {
					toast = Toast.makeText(this, "Not Updated.",
							Toast.LENGTH_LONG);
					toast.show();
				}

			}

			else {
				icareDS = new ICareDataSource(this);
				if (icareDS.insert(profileDataInsert) == true) {
					toast = Toast.makeText(this, "Successfully Submitted.",
							Toast.LENGTH_LONG);
					toast.show();
					finish();
//					startActivity(new Intent(ICareNewProfileActivity.this,
//							ICareDataViewActivity.class));
				} else {
					toast = Toast.makeText(this, "Not Submitted.",
							Toast.LENGTH_LONG);
					toast.show();
				}
			}

			break;
		case R.id.btnCancel:

			toast = Toast.makeText(this, "Successfully Canceled",
					Toast.LENGTH_LONG);
			toast.show();
			finish();
			break;
		}
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.icare_create_profile, menu);
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
