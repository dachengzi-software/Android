package com.ftfl.icareapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ICareProfileDataPreviewActivity extends Activity {
	TextView mTvName = null;
	TextView mTvFathersName = null;
	TextView mTvMothersName = null;
	TextView mTvAge = null;
	TextView mTvEyeColor = null;
	TextView mTvWeight = null;
	TextView mTvHeight = null;
	TextView mTvDateOfBirth = null;
	TextView mTvBirthPlace = null;
	TextView mTvSpecialName = null;
	String[] mProfileData = null;

	String mName = "";
	String mFathersName = "";
	String mMothersName = "";
	String mAge = "";
	String mEyeColor = "";
	String mWeight = "";
	String mHeight = "";
	String mDateOfBirth = "";
	String mBirthPlace = "";
	String mSpecialNotes = "";
	SharedPreferences sharedpreferences;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_icare_profile_data_preview);
		sharedpreferences = getSharedPreferences(
				ICareCreateProfileActivity.MyPREFERENCES, Context.MODE_PRIVATE);

		/*
		 * set view
		 */
		mTvName = (TextView) findViewById(R.id.db_name);
		mTvFathersName = (TextView) findViewById(R.id.db_fathers_name);
		mTvMothersName = (TextView) findViewById(R.id.db_mothers_name);
		mTvAge = (TextView) findViewById(R.id.db_age);
		mTvEyeColor = (TextView) findViewById(R.id.db_eye_color);
		mTvWeight = (TextView) findViewById(R.id.db_weight);
		mTvHeight = (TextView) findViewById(R.id.db_height);
		mTvDateOfBirth = (TextView) findViewById(R.id.db_date_of_birth);
		mTvBirthPlace = (TextView) findViewById(R.id.db_birth_place);
		mTvSpecialName = (TextView) findViewById(R.id.db_special_notes);

		if (sharedpreferences.contains(ICareCreateProfileActivity.NAME)
				&& sharedpreferences
						.contains(ICareCreateProfileActivity.FATHERNAME)
				&& sharedpreferences
						.contains(ICareCreateProfileActivity.MOTHERNAME)
				&& sharedpreferences.contains(ICareCreateProfileActivity.AGE)
				&& sharedpreferences
						.contains(ICareCreateProfileActivity.EYECOLOR)
				&& sharedpreferences
						.contains(ICareCreateProfileActivity.WEIGHT)
				&& sharedpreferences
						.contains(ICareCreateProfileActivity.HEIGHT)
				&& sharedpreferences
						.contains(ICareCreateProfileActivity.DATEOFBIRTH)
				&& sharedpreferences
						.contains(ICareCreateProfileActivity.BIRTHPLACE)
				&& sharedpreferences
						.contains(ICareCreateProfileActivity.SPECIALNOTE)) {
			setData();
		}
	}

	/*
	 * set data to the text field
	 */
	public void setData() {

		mName = sharedpreferences
				.getString(ICareCreateProfileActivity.NAME, "");
		mFathersName = sharedpreferences.getString(
				ICareCreateProfileActivity.FATHERNAME, "");
		mMothersName = sharedpreferences.getString(
				ICareCreateProfileActivity.MOTHERNAME, "");
		mAge = sharedpreferences.getString(ICareCreateProfileActivity.AGE, "");
		mEyeColor = sharedpreferences.getString(
				ICareCreateProfileActivity.EYECOLOR, "");
		mWeight = sharedpreferences.getString(
				ICareCreateProfileActivity.WEIGHT, "");
		mHeight = sharedpreferences.getString(
				ICareCreateProfileActivity.HEIGHT, "");
		mDateOfBirth = sharedpreferences.getString(
				ICareCreateProfileActivity.DATEOFBIRTH, "");
		mBirthPlace = sharedpreferences.getString(
				ICareCreateProfileActivity.BIRTHPLACE, "");
		mSpecialNotes = sharedpreferences.getString(
				ICareCreateProfileActivity.SPECIALNOTE, "");

		/*
		 * Set the data of database to the TextView
		 */

		mTvName.setText(mName);
		mTvFathersName.setText(mFathersName);
		mTvMothersName.setText(mMothersName);
		mTvAge.setText(mAge);
		mTvEyeColor.setText(mEyeColor);
		mTvWeight.setText(mWeight);
		mTvHeight.setText(mHeight);
		mTvDateOfBirth.setText(mDateOfBirth);
		mTvBirthPlace.setText(mBirthPlace);
		mTvSpecialName.setText(mSpecialNotes);
	}

	public void editData(View v) {
		Intent mPreviewIntent = new Intent(getApplicationContext(),
				ICareCreateProfileActivity.class);
		mPreviewIntent.putExtra("profileUpdate", "update");

		startActivity(mPreviewIntent);
	}

	public void deleteData(View v) {
		Editor editor = sharedpreferences.edit();
		editor.clear();
		editor.commit();
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.icare_profile_data_preview, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.edit:
			Intent mPreviewIntent = new Intent(getApplicationContext(),
					ICareCreateProfileActivity.class);
			mPreviewIntent.putExtra("profileUpdate", "update");

			startActivity(mPreviewIntent);
			return true;
		case R.id.delete:
			Editor editor = sharedpreferences.edit();
			editor.clear();
			editor.commit();
			finish();
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
