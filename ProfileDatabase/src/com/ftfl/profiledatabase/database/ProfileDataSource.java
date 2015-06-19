package com.ftfl.profiledatabase.database;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.ftfl.profiledatabase.utill.Profile;

public class ProfileDataSource {

	// Database fields
	private SQLiteDatabase profileDatabase;
	private ProfileSQLiteHelper profileDbHelper;
	List<Profile> profilesList = new ArrayList<Profile>();

	public ProfileDataSource(Context context) {
		profileDbHelper = new ProfileSQLiteHelper(context);
	}

	/*
	 * open a method for writable database
	 */
	public void open() throws SQLException {
		profileDatabase = profileDbHelper.getWritableDatabase();
	}

	/*
	 * close database connection
	 */
	public void close() {
		profileDbHelper.close();
	}

	/*
	 * insert data into the database.
	 */

	public boolean insert(Profile eProfile) {

		this.open();

		ContentValues cv = new ContentValues();

		cv.put(ProfileSQLiteHelper.COL_PROFILE_NAME, eProfile.getName());
		cv.put(ProfileSQLiteHelper.COL_PROFILE_FATHER_NAME,
				eProfile.getFatherName());
		cv.put(ProfileSQLiteHelper.COL_PROFILE_MOTHER_NAME,
				eProfile.getMotherName());
		cv.put(ProfileSQLiteHelper.COL_PROFILE_AGE, eProfile.getAge());

		long check = profileDatabase.insert(ProfileSQLiteHelper.TABLE_PROFILE,
				null, cv);
		profileDatabase.close();

		this.close();
		if (check < 0)
			return false;
		else
			return true;
	}

	// Updating database by id
	public boolean updateData(long eProfileId, Profile eProfile) {
		this.open();
		ContentValues cvUpdate = new ContentValues();

		cvUpdate.put(ProfileSQLiteHelper.COL_PROFILE_NAME, eProfile.getName());
		cvUpdate.put(ProfileSQLiteHelper.COL_PROFILE_FATHER_NAME,
				eProfile.getFatherName());
		cvUpdate.put(ProfileSQLiteHelper.COL_PROFILE_MOTHER_NAME,
				eProfile.getMotherName());
		cvUpdate.put(ProfileSQLiteHelper.COL_PROFILE_AGE, eProfile.getAge());

		int check = profileDatabase.update(ProfileSQLiteHelper.TABLE_PROFILE,
				cvUpdate,
				ProfileSQLiteHelper.COL_PROFILE_ID + "=" + eProfileId, null);
		profileDatabase.close();

		this.close();

		this.close();
		if (check == 0)
			return false;
		else
			return true;
	}

	// delete data form database.
	public boolean deleteData(long eProfileId) {
		this.open();
		try {
			profileDatabase
					.delete(ProfileSQLiteHelper.TABLE_PROFILE,
							ProfileSQLiteHelper.COL_PROFILE_ID + "="
									+ eProfileId, null);
		} catch (Exception ex) {
			Log.e("ERROR", "data insertion problem");
			return false;
		}
		this.close();
		return true;
	}

	/*
	 * using cursor for display data from database.
	 */
	public List<Profile> profilesList() {
		this.open();

		Cursor mCursor = profileDatabase.query(
				ProfileSQLiteHelper.TABLE_PROFILE, new String[] {
						ProfileSQLiteHelper.COL_PROFILE_ID,
						ProfileSQLiteHelper.COL_PROFILE_NAME,
						ProfileSQLiteHelper.COL_PROFILE_FATHER_NAME,
						ProfileSQLiteHelper.COL_PROFILE_MOTHER_NAME,
						ProfileSQLiteHelper.COL_PROFILE_AGE, }, null, null,
				null, null, null);

		if (mCursor != null) {
			if (mCursor.moveToFirst()) {

				do {

					String id = mCursor
							.getString(mCursor
									.getColumnIndex(ProfileSQLiteHelper.COL_PROFILE_ID));
					String name = mCursor
							.getString(mCursor
									.getColumnIndex(ProfileSQLiteHelper.COL_PROFILE_NAME));
					String fatherName = mCursor
							.getString(mCursor
									.getColumnIndex(ProfileSQLiteHelper.COL_PROFILE_FATHER_NAME));
					String motherName = mCursor
							.getString(mCursor
									.getColumnIndex(ProfileSQLiteHelper.COL_PROFILE_MOTHER_NAME));
					String age = mCursor
							.getString(mCursor
									.getColumnIndex(ProfileSQLiteHelper.COL_PROFILE_AGE));

					profilesList.add(new Profile(id, name, fatherName,
							motherName, age));

				} while (mCursor.moveToNext());
			}
			mCursor.close();
		}
		this.close();
		return profilesList;
	}

	/*
	 * create a profile of ICareProfile. Here the data of the database according
	 * to the given id is set to the profile and return a profile.
	 */
	public Profile singleProfileData(long profileID) {
		this.open();
		Profile iCareUpdateProfile;
		String id;
		String name;
		String fathersName;
		String mothersName;
		String age;

		Cursor mUpdateCursor = profileDatabase.query(
				ProfileSQLiteHelper.TABLE_PROFILE, new String[] {
						ProfileSQLiteHelper.COL_PROFILE_ID,
						ProfileSQLiteHelper.COL_PROFILE_NAME,
						ProfileSQLiteHelper.COL_PROFILE_FATHER_NAME,
						ProfileSQLiteHelper.COL_PROFILE_MOTHER_NAME,
						ProfileSQLiteHelper.COL_PROFILE_AGE, },
				ProfileSQLiteHelper.COL_PROFILE_ID + "=" + profileID, null,
				null, null, null);

		mUpdateCursor.moveToFirst();

		id = mUpdateCursor.getString(mUpdateCursor
				.getColumnIndex(ProfileSQLiteHelper.COL_PROFILE_ID));
		name = mUpdateCursor.getString(mUpdateCursor
				.getColumnIndex(ProfileSQLiteHelper.COL_PROFILE_NAME));
		fathersName = mUpdateCursor.getString(mUpdateCursor
				.getColumnIndex(ProfileSQLiteHelper.COL_PROFILE_FATHER_NAME));
		mothersName = mUpdateCursor.getString(mUpdateCursor
				.getColumnIndex(ProfileSQLiteHelper.COL_PROFILE_MOTHER_NAME));
		age = mUpdateCursor.getString(mUpdateCursor
				.getColumnIndex(ProfileSQLiteHelper.COL_PROFILE_AGE));

		mUpdateCursor.close();
		iCareUpdateProfile = new Profile(id, name, fathersName, mothersName,
				age);
		this.close();
		return iCareUpdateProfile;
	}
}
