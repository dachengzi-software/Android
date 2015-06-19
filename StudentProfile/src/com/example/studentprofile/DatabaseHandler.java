package com.example.studentprofile;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "profileManager";

	// Contacts table name
	private static final String TABLE_PROFILE = "profile";

	// Contacts Table Columns names
	private static final String KEY_ID = "id";
	private static final String KEY_NAME = "name";
	private static final String KEY_F_NAME = "fathersName";
	private static final String KEY_M_NAME = "mothersName";
	private static final String KEY_DOB = "dateOfBirth";
	private static final String KEY_GENDER = "gender";
	private static final String KEY_WEIGHT = "weight";
	private static final String KEY_F_HEIGHT = "height";

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_PROFILES_TABLE = "CREATE TABLE " + TABLE_PROFILE + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
				+ KEY_F_NAME + " TEXT" + KEY_M_NAME + " TEXT" + KEY_DOB
				+ " TEXT" + KEY_GENDER + " TEXT" + KEY_WEIGHT + " TEXT"
				+ KEY_F_HEIGHT + " TEXT" + ")";
		db.execSQL(CREATE_PROFILES_TABLE);
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROFILE);

		// Create tables again
		onCreate(db);
	}

	/**
	 * All CRUD(Create, Read, Update, Delete) Operations
	 */

	// Adding new contact
	void addProfile(Profile p) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_NAME, p.getName()); // Profile Name
		values.put(KEY_F_NAME, p.getFathersName()); // Contact Phone
		values.put(KEY_M_NAME, p.getMothersName());
		values.put(KEY_DOB, p.getDateOfBirth());
		values.put(KEY_GENDER, p.getGender());
		values.put(KEY_WEIGHT, p.getWeight());
		values.put(KEY_F_HEIGHT, p.getHeight());

		// Inserting Row
		db.insert(TABLE_PROFILE, null, values);
		db.close(); // Closing database connection
	}

	// Getting single contact
	Profile getProfile(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLE_PROFILE, new String[] { KEY_ID,
				KEY_NAME, KEY_F_NAME, KEY_M_NAME, KEY_DOB, KEY_GENDER,
				KEY_WEIGHT, KEY_F_HEIGHT }, KEY_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		Profile p = new Profile(Integer.parseInt(cursor.getString(0)),
				cursor.getString(1), cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7));
		// return contact
		return p;
	}

	// Getting All Contacts
	public ArrayList<Profile> getAllProfiles() {
		ArrayList<Profile> profileList = new ArrayList<Profile>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_PROFILE;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Profile p = new Profile();
				p.setId(Integer.parseInt(cursor.getString(0)));
				p.setName(cursor.getString(1));
				p.setFathersName(cursor.getString(2));
				p.setMothersName(cursor.getString(3));
				p.setDateOfBirth(cursor.getString(4));
				p.setGender(cursor.getString(5));
				p.setWeight(cursor.getString(6));
				p.setHeight(cursor.getString(7));
				// Adding contact to list
				profileList.add(p);
			} while (cursor.moveToNext());
		}

		// return contact list
		return profileList;
	}

	// Updating single contact
	public int updateContact(Profile p) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_NAME, p.getName());
		values.put(KEY_F_NAME, p.getFathersName());
		values.put(KEY_M_NAME, p.getMothersName());
		values.put(KEY_DOB, p.getDateOfBirth());
		values.put(KEY_GENDER, p.getGender());
		values.put(KEY_WEIGHT, p.getWeight());
		values.put(KEY_F_HEIGHT, p.getHeight());

		// updating row
		return db.update(TABLE_PROFILE, values, KEY_ID + " = ?",
				new String[] { String.valueOf(p.getId()) });
	}

	// Deleting single contact
	public void deleteContact(Profile p) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_PROFILE, KEY_ID + " = ?",
				new String[] { String.valueOf(p.getId()) });
		db.close();
	}

	// Getting contacts Count
	public int getProfileCount() {
		String countQuery = "SELECT  * FROM " + TABLE_PROFILE;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();

		// return count
		return cursor.getCount();
	}

}
