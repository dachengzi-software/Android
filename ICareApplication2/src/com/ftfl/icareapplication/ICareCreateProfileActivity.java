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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ICareCreateProfileActivity extends Activity {
	EditText etName = null;
	EditText et_fathersName = null;
	EditText et_mothersName = null;
	EditText et_age = null;
	EditText et_eyeColor = null;
	EditText et_weight = null;
	EditText et_height = null;
	EditText et_dateOfBirth = null;
	EditText et_birthPlace = null;
	EditText et_specialNotes = null;

	String mName = "";
	String mFatherName = "";
	String mMotherName = "";
	String mAge = "";
	String mEyeColor = "";
	String mWeight = "";
	String mHeight = "";
	String mDateOfBirth = "";
	String mBirthPlace = "";
	String mSpecialNotes = "";
	String mData = "";
	String mCheck = null;

	public static final String MyPREFERENCES = "MyPrefs";
	public static final String NAME = "name";
	public static final String FATHERNAME = "fathername";
	public static final String MOTHERNAME = "mothername";
	public static final String AGE = "age";
	public static final String EYECOLOR = "eyecolor";
	public static final String WEIGHT = "weight";
	public static final String HEIGHT = "height";
	public static final String DATEOFBIRTH = "dateofbirth";
	public static final String BIRTHPLACE = "birthplace";
	public static final String SPECIALNOTE = "specialnote";
	SharedPreferences sharedpreferences;
	Button btnSave = null;

	Toast toast = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_icare_create_profile);

		sharedpreferences = getSharedPreferences(MyPREFERENCES,
				Context.MODE_PRIVATE);

		// set the text field id to the variable.
		etName = (EditText) findViewById(R.id.name);
		et_fathersName = (EditText) findViewById(R.id.fathers_name);
		et_mothersName = (EditText) findViewById(R.id.mothers_name);
		et_age = (EditText) findViewById(R.id.age);
		et_eyeColor = (EditText) findViewById(R.id.eye_color);
		et_weight = (EditText) findViewById(R.id.weight);
		et_height = (EditText) findViewById(R.id.height);
		et_dateOfBirth = (EditText) findViewById(R.id.date_of_birth);
		et_birthPlace = (EditText) findViewById(R.id.birth_place);
		et_specialNotes = (EditText) findViewById(R.id.special_notes);
		btnSave = (Button) findViewById(R.id.btnSubmit);

		Intent mIntent = getIntent();
		mCheck = mIntent.getStringExtra("profileUpdate");

		if (mCheck != null) {

			mName = sharedpreferences.getString(NAME, "");
			mFatherName = sharedpreferences.getString(FATHERNAME, "");
			mMotherName = sharedpreferences.getString(MOTHERNAME, "");
			mAge = sharedpreferences.getString(AGE, "");
			mEyeColor = sharedpreferences.getString(EYECOLOR, "");
			mWeight = sharedpreferences.getString(WEIGHT, "");
			mHeight = sharedpreferences.getString(HEIGHT, "");
			mDateOfBirth = sharedpreferences.getString(DATEOFBIRTH, "");
			mBirthPlace = sharedpreferences.getString(BIRTHPLACE, "");
			mSpecialNotes = sharedpreferences.getString(SPECIALNOTE, "");

			/*
			 * Set the data of database to the TextView
			 */

			etName.setText(mName);
			et_fathersName.setText(mFatherName);
			et_mothersName.setText(mMotherName);
			et_age.setText(mAge);
			et_eyeColor.setText(mEyeColor);
			et_weight.setText(mWeight);
			et_height.setText(mHeight);
			et_dateOfBirth.setText(mDateOfBirth);
			et_birthPlace.setText(mBirthPlace);
			et_specialNotes.setText(mSpecialNotes);

			btnSave.setText("Update");

		}

	}

	public void saveData(View v) {
		mName = etName.getText().toString();
		mFatherName = et_fathersName.getText().toString();
		mMotherName = et_mothersName.getText().toString();
		mAge = et_age.getText().toString();
		mEyeColor = et_eyeColor.getText().toString();
		mWeight = et_weight.getText().toString();
		mHeight = et_height.getText().toString();
		mDateOfBirth = et_dateOfBirth.getText().toString();
		mBirthPlace = et_birthPlace.getText().toString();
		mSpecialNotes = et_specialNotes.getText().toString();
		Editor editor = sharedpreferences.edit();

		editor.putString(NAME, mName);
		editor.putString(FATHERNAME, mFatherName);
		editor.putString(MOTHERNAME, mMotherName);
		editor.putString(AGE, mAge);
		editor.putString(EYECOLOR, mEyeColor);
		editor.putString(WEIGHT, mWeight);
		editor.putString(HEIGHT, mHeight);
		editor.putString(DATEOFBIRTH, mDateOfBirth);
		editor.putString(BIRTHPLACE, mBirthPlace);
		editor.putString(SPECIALNOTE, mSpecialNotes);
		editor.commit();

		if (mCheck != null) {
			toast = Toast.makeText(this, "Successfully Updated.",
					Toast.LENGTH_LONG);
			toast.show();
			startActivity(new Intent(ICareCreateProfileActivity.this,
					ICareActivity.class));
			finish();
		}

		else {
			toast = Toast.makeText(this, "Successfully Saved.",
					Toast.LENGTH_LONG);
			toast.show();
			finish();
		}
	}

	public void cancelCreate(View v) {
		finish();
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
