package com.ftfl.icareprofile.database;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.ftfl.icareprofile.utill.ICareProfile;

public class ICareDataSource {

	// Database fields
	private SQLiteDatabase iCareDatabase;
	private ICareSQLiteHelper iCareDbHelper;
	List<ICareProfile> iCareProfilesList = new ArrayList<ICareProfile>();

	public ICareDataSource(Context context) {
		iCareDbHelper = new ICareSQLiteHelper(context);
	}

	/*
	 * open a method for writable database
	 */
	public void open() throws SQLException {
		iCareDatabase = iCareDbHelper.getWritableDatabase();
	}

	/*
	 * close database connection
	 */
	public void close() {
		iCareDbHelper.close();
	}

	/*
	 * insert data into the database.
	 */

	public boolean insert(ICareProfile iprofile) {

		this.open();

		ContentValues cv = new ContentValues();

		cv.put(ICareSQLiteHelper.COL_ICARE_PROFILE_NAME, iprofile.getName());
		cv.put(ICareSQLiteHelper.COL_ICARE_PROFILE_FATHERS_NAME,
				iprofile.getFatherName());
		cv.put(ICareSQLiteHelper.COL_ICARE_PROFILE_MOTHERS_NAME,
				iprofile.getMotherName());
		cv.put(ICareSQLiteHelper.COL_ICARE_PROFILE_AGE, iprofile.getAge());
		

		try {
			iCareDatabase.insert(ICareSQLiteHelper.I_CARE_PROFILE, null, cv);
			iCareDatabase.close();
		} catch (Exception ex) {
			Log.e("ERROR", "data insertion problem");
			return false;
		}
		this.close();
		return true;
	}

	// Updating database by id
	public boolean updateData(long profileId, ICareProfile iprofile) {
		this.open();
		ContentValues cvUpdate = new ContentValues();

		cvUpdate.put(ICareSQLiteHelper.COL_ICARE_PROFILE_NAME,
				iprofile.getName());
		cvUpdate.put(ICareSQLiteHelper.COL_ICARE_PROFILE_FATHERS_NAME,
				iprofile.getFatherName());
		cvUpdate.put(ICareSQLiteHelper.COL_ICARE_PROFILE_MOTHERS_NAME,
				iprofile.getMotherName());
		cvUpdate.put(ICareSQLiteHelper.COL_ICARE_PROFILE_AGE, iprofile.getAge());
		

		try {
			iCareDatabase.update(ICareSQLiteHelper.I_CARE_PROFILE, cvUpdate,
					ICareSQLiteHelper.COL_ICARE_PROFILE_ID + "=" + profileId,
					null);
			iCareDatabase.close();
		} catch (Exception ex) {
			Log.e("ERROR", "data insertion problem");
			return false;
		}
		this.close();
		return true;
	}

	// delete data form database.
	public boolean deleteData(long profileId) {
		this.open();
		try {
			iCareDatabase.delete(ICareSQLiteHelper.I_CARE_PROFILE,
					ICareSQLiteHelper.COL_ICARE_PROFILE_ID + "=" + profileId,
					null);
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
	public List<ICareProfile> iCareProfilesList() {
		this.open();

		Cursor mCursor = iCareDatabase.query(ICareSQLiteHelper.I_CARE_PROFILE,
				new String[] { ICareSQLiteHelper.COL_ICARE_PROFILE_ID,
						ICareSQLiteHelper.COL_ICARE_PROFILE_NAME,
						ICareSQLiteHelper.COL_ICARE_PROFILE_FATHERS_NAME,
						ICareSQLiteHelper.COL_ICARE_PROFILE_MOTHERS_NAME,
						ICareSQLiteHelper.COL_ICARE_PROFILE_AGE,
						 }, null,
				null, null, null, null);

		if (mCursor != null) {
			if (mCursor.moveToFirst()) {

				do {

					String mId = mCursor
							.getString(mCursor.getColumnIndex("id"));
					String mName = mCursor.getString(mCursor
							.getColumnIndex("name"));
					String mFathersName = mCursor.getString(mCursor
							.getColumnIndex("fathersname"));
					String mMothersName = mCursor.getString(mCursor
							.getColumnIndex("mothersname"));
					String mAge = mCursor.getString(mCursor
							.getColumnIndex("age"));
					
				
					iCareProfilesList.add(new ICareProfile(mId, mName,
							mFathersName, mMothersName, mAge));

				} while (mCursor.moveToNext());
			}
			mCursor.close();
		}
		this.close();
		return iCareProfilesList;
	}

	/*
	 * create a profile of ICareProfile. Here the data of the database according
	 * to the given id is set to the profile and return a profile.
	 */
	public ICareProfile updateProfileData(long profileID) {
		this.open();
		ICareProfile iCareUpdateProfile;
		String mId;
		String mName;
		String mFathersName;
		String mMothersName;
		String mAge;
	

		Cursor mUpdateCursor = iCareDatabase.query(
				ICareSQLiteHelper.I_CARE_PROFILE, new String[] {
						ICareSQLiteHelper.COL_ICARE_PROFILE_ID,
						ICareSQLiteHelper.COL_ICARE_PROFILE_NAME,
						ICareSQLiteHelper.COL_ICARE_PROFILE_FATHERS_NAME,
						ICareSQLiteHelper.COL_ICARE_PROFILE_MOTHERS_NAME,
						ICareSQLiteHelper.COL_ICARE_PROFILE_AGE,
						},
				ICareSQLiteHelper.COL_ICARE_PROFILE_ID + "=" + profileID, null,
				null, null, null);

		mUpdateCursor.moveToFirst();

		mId = mUpdateCursor.getString(mUpdateCursor.getColumnIndex("id"));
		mName = mUpdateCursor.getString(mUpdateCursor.getColumnIndex("name"));
		mFathersName = mUpdateCursor.getString(mUpdateCursor
				.getColumnIndex("fathersname"));
		mMothersName = mUpdateCursor.getString(mUpdateCursor
				.getColumnIndex("mothersname"));
		mAge = mUpdateCursor.getString(mUpdateCursor.getColumnIndex("age"));
		
		mUpdateCursor.close();
		iCareUpdateProfile = new ICareProfile(mId, mName, mFathersName,
				mMothersName, mAge);
		this.close();
		return iCareUpdateProfile;
	}
}
