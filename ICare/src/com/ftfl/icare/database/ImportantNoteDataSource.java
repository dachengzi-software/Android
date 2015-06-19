package com.ftfl.icare.database;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.ftfl.icare.util.ICareConstants;
import com.ftfl.icare.util.ImportantNotes;

public class ImportantNoteDataSource {
	private SQLiteDatabase mICareDatabase;
	private ICareSQLiteHelper mICareDbHelper;
	List<ImportantNotes> mImportantNotesList = new ArrayList<ImportantNotes>();

	public ImportantNoteDataSource(Context context) {
		mICareDbHelper = new ICareSQLiteHelper(context);
	}

	/*
	 * open a method for writable database
	 */
	public void open() throws SQLException {
		mICareDatabase = mICareDbHelper.getWritableDatabase();
	}

	/*
	 * close database connection
	 */
	public void close() {
		mICareDbHelper.close();
	}

	/*
	 * insert data into the database.
	 */
	
	public boolean insert(ImportantNotes eNotes) {

		this.open();

		ContentValues cv = new ContentValues();

		cv.put(ICareSQLiteHelper.COL_NOTE_TITLE, eNotes.getTitle());

		cv.put(ICareSQLiteHelper.COL_NOTE_SUBJECT,
				eNotes.getSubject());
		cv.put(ICareSQLiteHelper.COL_DESCRIPTION, eNotes.getDescription());
		cv.put(ICareSQLiteHelper.COL_NOTE_PROFILE_ID, eNotes.getProfileId());

		long check = mICareDatabase.insert(
				ICareSQLiteHelper.TABLE_IMPORTANT_NOTE, null, cv);
		mICareDatabase.close();

		this.close();
		if (check < 0)
			return false;
		else
			return true;
	}
	

	// Updating database by id
	public boolean updateData(int eNoteId, ImportantNotes eNotes) {
		this.open();
		ContentValues cv = new ContentValues();


		cv.put(ICareSQLiteHelper.COL_NOTE_TITLE, eNotes.getTitle());

		cv.put(ICareSQLiteHelper.COL_NOTE_SUBJECT,
				eNotes.getSubject());
		cv.put(ICareSQLiteHelper.COL_DESCRIPTION, eNotes.getDescription());
		cv.put(ICareSQLiteHelper.COL_NOTE_PROFILE_ID, eNotes.getProfileId());

		int check = mICareDatabase.update(
				ICareSQLiteHelper.TABLE_IMPORTANT_NOTE, cv,
				ICareSQLiteHelper.COL_NOTE_ID + "=" + eNoteId, null);
		mICareDatabase.close();

		this.close();
		if (check == 0)
			return false;
		else
			return true;
	}
	
	// delete data form database.
	public boolean deleteData(int eNoteId) {
		this.open();
		try {
			mICareDatabase.delete(ICareSQLiteHelper.TABLE_IMPORTANT_NOTE,
					ICareSQLiteHelper.COL_NOTE_ID + "=" + eNoteId, null);
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
	public List<ImportantNotes> notesList() {
		this.open();

		Cursor mCursor = mICareDatabase.query(
				ICareSQLiteHelper.TABLE_IMPORTANT_NOTE, null, ICareSQLiteHelper.COL_NOTE_PROFILE_ID + "=" + ICareConstants.SELECTED_PROFILE_ID, null, null,
				null, null);

		if (mCursor != null) {
			if (mCursor.moveToFirst()) {

				do {

					String id = mCursor.getString(mCursor
							.getColumnIndex(ICareSQLiteHelper.COL_NOTE_ID));
					String title = mCursor.getString(mCursor
							.getColumnIndex(ICareSQLiteHelper.COL_NOTE_TITLE));
					String subject = mCursor
							.getString(mCursor
									.getColumnIndex(ICareSQLiteHelper.COL_NOTE_SUBJECT));
					String description = mCursor
							.getString(mCursor
									.getColumnIndex(ICareSQLiteHelper.COL_DESCRIPTION));
			
					String profileId = mCursor
							.getString(mCursor
									.getColumnIndex(ICareSQLiteHelper.COL_NOTE_PROFILE_ID));

					mImportantNotesList.add(new ImportantNotes(id, title,
							subject, description, profileId));

				} while (mCursor.moveToNext());
			}
			mCursor.close();
		}
		this.close();
		return mImportantNotesList;
	}
	
	
	/*
	 * create a profile of ICareProfile. Here the data of the database according
	 * to the given id is set to the profile and return a profile.
	 */
	public ImportantNotes singleNoteData(int eNoteId) {
		this.open();
		ImportantNotes singleNote;
		Cursor mCursor = mICareDatabase.query(
				ICareSQLiteHelper.TABLE_IMPORTANT_NOTE, null,
				ICareSQLiteHelper.COL_NOTE_ID + "=" + eNoteId, null, null,
				null, null);

		mCursor.moveToFirst();

		String id = mCursor.getString(mCursor
				.getColumnIndex(ICareSQLiteHelper.COL_NOTE_ID));
		String title = mCursor.getString(mCursor
				.getColumnIndex(ICareSQLiteHelper.COL_NOTE_TITLE));
		String subject = mCursor
				.getString(mCursor
						.getColumnIndex(ICareSQLiteHelper.COL_NOTE_SUBJECT));
		String description = mCursor
				.getString(mCursor
						.getColumnIndex(ICareSQLiteHelper.COL_DESCRIPTION));

		String profileId = mCursor
				.getString(mCursor
						.getColumnIndex(ICareSQLiteHelper.COL_NOTE_PROFILE_ID));
		mCursor.close();

		singleNote = new ImportantNotes(id, title,
				subject, description, profileId);
		this.close();
		return singleNote;
	}
}
