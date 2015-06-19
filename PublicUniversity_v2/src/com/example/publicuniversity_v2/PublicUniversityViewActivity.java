package com.example.publicuniversity_v2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.example.publcuniversity_v2.database.DataSources;
import com.example.publicuniversity_v2.util.PublicUniversity;

public class PublicUniversityViewActivity extends ActionBarActivity {

	EditText etName, etDescription, etAddress, etLatitude, etLongitude,
			etCourse, etStudent, etTeacher;

	DataSources mPublicUniversityDS = null;
	PublicUniversity mUpdatePublicUniversity = null;

	String mID = "";
	Long mLId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_university_view);

		etName = (EditText) findViewById(R.id.addName);
		etDescription = (EditText) findViewById(R.id.addDescription);
		etAddress = (EditText) findViewById(R.id.addAddress);
		etLatitude = (EditText) findViewById(R.id.addLatitude);
		etLongitude = (EditText) findViewById(R.id.addLongitude);
		etCourse = (EditText) findViewById(R.id.addCourses);
		etStudent = (EditText) findViewById(R.id.addStudent);
		etTeacher = (EditText) findViewById(R.id.addTeachers);

		Intent mActivityIntent = getIntent();
		mID = mActivityIntent.getStringExtra("id");

		if (mID != null) {
			mLId = Long.parseLong(mID);

			/*
			 * get the activity which include all data from database according
			 * profileId of the clicked item.
			 */
			mPublicUniversityDS = new DataSources(this);
			mUpdatePublicUniversity = mPublicUniversityDS
					.singlePublicUniversityData(mLId);

			String mName = mUpdatePublicUniversity.getmName();
			String mDescription = mUpdatePublicUniversity.getmDescription();
			String mAddress = mUpdatePublicUniversity.getmAddress();
			String mLatitude = mUpdatePublicUniversity.getmLatitude();
			String mLongitude = mUpdatePublicUniversity.getmLongitude();
			String mCourse = mUpdatePublicUniversity.getmCourse();
			String mStudent = mUpdatePublicUniversity.getmStudent();
			String mTeachers = mUpdatePublicUniversity.getmTeachers();

			// set the value of database to the text field.

			etName.setText(mName);
			etName.setFocusable(false);
			etName.setClickable(false);
			etDescription.setText(mDescription);
			etDescription.setFocusable(false);
			etDescription.setClickable(false);
			etAddress.setText(mAddress);
			etAddress.setFocusable(false);
			etAddress.setClickable(false);
			etLatitude.setText(mLatitude);
			etLatitude.setFocusable(false);
			etLatitude.setClickable(false);
			etLongitude.setText(mLongitude);
			etLongitude.setFocusable(false);
			etLongitude.setClickable(false);
			etCourse.setText(mCourse);
			etCourse.setFocusable(false);
			etCourse.setClickable(false);
			etStudent.setText(mStudent);
			etStudent.setFocusable(false);
			etStudent.setClickable(false);
			etTeacher.setText(mTeachers);
			etTeacher.setFocusable(false);
			etTeacher.setClickable(false);

		}
	}
}
