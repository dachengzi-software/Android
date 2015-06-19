package com.ftfl.mymeetingplaces;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ftfl.mymeetingplaces.database.MeetingPlaceDataSource;
import com.ftfl.mymeetingplaces.util.MeetingPlace;

public class MeetingPlaceActivity extends Activity {

	static final int CAMERA_REQUEST = 1;
	static final int AUDIO_REQUEST = 5;
	String mImagePath = null;
	static final String IMAGE_DIRECTORY_NAME = "MeetingPlace Images";
	File image = null;
	ImageView mIvCapturedImage = null;
	Button mBtnTakePicture = null;

	TextView mTvLatitude = null;
	TextView mTvLongitude = null;
	TextView mTvAudio = null;
	EditText mEtRemark = null;
	EditText mEtName = null;
	EditText mEtMobile = null;
	EditText mEtEmail = null;
	Calendar mCalendar = Calendar.getInstance();
	Integer mHour = 0;
	Integer mMinute = 0;
	Integer mYear = 0;
	Integer mDay = 0;
	Integer mMonth = 0;
	String mDate = "";
	String mTime = "";
	String mAudioPath = "";
	String mName = "";
	String mMobile = "";
	String mEmail = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_meeting_place);

		mIvCapturedImage = (ImageView) findViewById(R.id.imageviewShowImage);
		mBtnTakePicture = (Button) findViewById(R.id.buttonCapture);

		mYear = mCalendar.get(Calendar.YEAR);
		mMonth = mCalendar.get(Calendar.MONTH);
		mDay = mCalendar.get(Calendar.DAY_OF_MONTH);

		mHour = mCalendar.get(Calendar.HOUR_OF_DAY);
		mMinute = mCalendar.get(Calendar.MINUTE);

		mDate = mDay.toString() + "/" + mMonth.toString() + "/"
				+ mYear.toString();
		mTime = mHour.toString() + ":" + mMinute.toString();

		mTvLatitude = (TextView) findViewById(R.id.tvLatitude);
		mTvLongitude = (TextView) findViewById(R.id.tvLongitude);
		mTvAudio = (TextView) findViewById(R.id.tvViewAudioFile);
		mEtRemark = (EditText) findViewById(R.id.etRemark);
		
		mEtName = (EditText) findViewById(R.id.etName);
		mEtMobile = (EditText) findViewById(R.id.etMobile);
		mEtEmail = (EditText) findViewById(R.id.etEmail);

		try {
			LocationManager locMgr = (LocationManager) this
					.getSystemService(Context.LOCATION_SERVICE);
			Criteria criteria = new Criteria();
			String locProvider = locMgr.getBestProvider(criteria, false);
			Location location = locMgr.getLastKnownLocation(locProvider);

			// getting GPS status
			boolean isGPSEnabled = locMgr
					.isProviderEnabled(LocationManager.GPS_PROVIDER);
			// getting network status
			boolean isNWEnabled = locMgr
					.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

			if (isGPSEnabled && isNWEnabled)

			{
				if (isNWEnabled)
					if (locMgr != null)
						location = locMgr
								.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
				if (isGPSEnabled)
					if (location == null)
						if (locMgr != null)
							location = locMgr
									.getLastKnownLocation(LocationManager.GPS_PROVIDER);
			}

			// Getting latitude of the current location
			Double latitude = location.getLatitude();

			// Getting longitude of the current location
			Double longitude = location.getLongitude();

			mTvLatitude.setText(latitude.toString());
			mTvLongitude.setText(longitude.toString());

		} catch (NullPointerException ne) {
			Log.e("Current Location", "Current Lat Lng is Null");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_visiting_place, menu);
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

	/**
	 * open camera method
	 */
	public void callCamera(View v) {

		Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		// Ensure that there's a camera activity to handle the intent
		if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
			// Create the File where the photo should go
			File photoFile = null;
			try {
				photoFile = createImageFile();
			} catch (IOException ex) {
				Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT)
						.show();
			}
			// Continue only if the File was successfully created
			if (photoFile != null) {
				takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
						Uri.fromFile(photoFile));
				startActivityForResult(takePictureIntent, CAMERA_REQUEST);
			}
		}
	}

	private File createImageFile() throws IOException {

		if (image == null) {
			// External SD card location
			File mediaStorageDir = new File(
					Environment
							.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
					IMAGE_DIRECTORY_NAME);

			// Create the storage directory if it does not exist
			if (!mediaStorageDir.exists()) {
				if (!mediaStorageDir.mkdirs()) {
					return null;
				}
			}

			// Create an image file name
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
					Locale.getDefault()).format(new Date());
			String imageFileName = "JPEG_" + timeStamp + "_";
			image = File.createTempFile(imageFileName, /* prefix */
					".jpg", /* suffix */
					mediaStorageDir /* directory */
			);
		}

		mImagePath = image.getAbsolutePath();
		return image;
	}
	
	
	public void performRecord(View v) {

		Intent takePictureIntent = new Intent(
				MediaStore.Audio.Media.RECORD_SOUND_ACTION);
		// Ensure that there's a camera activity to handle the intent
		if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
			// Create the File where the photo should go
		/*	File audioFile = null;
			try {
				audioFile = createAudioFile();
			} catch (IOException ex) {
				Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT)
						.show();
			}
			// Continue only if the File was successfully created
			if (audioFile != null) {
				takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
						Uri.fromFile(audioFile));
				startActivityForResult(takePictureIntent, AUDIO_REQUEST);
			}*/
			
			startActivityForResult(takePictureIntent, AUDIO_REQUEST);
		}

	}

	/**
	 * On activity result
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
			if (mImagePath != null) {

				mBtnTakePicture.setText("Change Image");

				Bitmap correctBmp = null;

				try {
					File f = new File(mImagePath);
					ExifInterface exif = new ExifInterface(f.getPath());
					int orientation = exif.getAttributeInt(
							ExifInterface.TAG_ORIENTATION,
							ExifInterface.ORIENTATION_NORMAL);

					int angle = 0;

					if (orientation == ExifInterface.ORIENTATION_ROTATE_90) {
						angle = 90;
					} else if (orientation == ExifInterface.ORIENTATION_ROTATE_180) {
						angle = 180;
					} else if (orientation == ExifInterface.ORIENTATION_ROTATE_270) {
						angle = 270;
					}

					Matrix mat = new Matrix();
					mat.postRotate(angle);
					BitmapFactory.Options option = new BitmapFactory.Options();
					option.inSampleSize = 8;
					Bitmap bmp1 = BitmapFactory.decodeStream(
							new FileInputStream(f), null, option);
					correctBmp = Bitmap.createBitmap(bmp1, 0, 0,
							bmp1.getWidth(), bmp1.getHeight(), mat, true);
				} catch (IOException e) {
					Log.w("TAG", "-- Error in setting image");
				} catch (OutOfMemoryError oom) {
					Log.w("TAG", "-- OOM Error in setting image");
				}
				mIvCapturedImage.setImageBitmap(correctBmp);
			}
		}
		
		else if (requestCode == AUDIO_REQUEST && resultCode == RESULT_OK) {
			
			Uri audioUri = data.getData();
			mAudioPath = getPath(audioUri);
			mTvAudio.setText(mAudioPath);
		}
	}
	
	/*
	 * Uri method to get image file path
	 */
	@SuppressWarnings("deprecation")
	public String getPath(Uri uri) {
		String[] projection = { MediaStore.Images.Media.DATA };
		Cursor cursor = managedQuery(uri, projection, null, null, null);
		int column_index = cursor
				.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
		cursor.moveToFirst();
		return cursor.getString(column_index);
	}

	public void performSave(View v) {

		MeetingPlaceDataSource imageDS = new MeetingPlaceDataSource(this);
		String description = mEtRemark.getText().toString();
		String latitude = mTvLatitude.getText().toString();
		String longitude = mTvLongitude.getText().toString();
		
		mName = mEtName.getText().toString();
		mMobile = mEtMobile.getText().toString();
		mEmail = mEtEmail.getText().toString();

		if (image == null) {
			Toast.makeText(getApplicationContext(), "Please Take a Photo.",
					Toast.LENGTH_SHORT).show();
		}

		else {
			MeetingPlace imageInsert = new MeetingPlace();

			imageInsert.setLatitude(latitude);
			imageInsert.setLongitude(longitude);
			imageInsert.setDescription(description);
			imageInsert.setFileName(mImagePath);
			imageInsert.setDate(mDate);
			imageInsert.setTime(mTime);
			imageInsert.setName(mName);
			imageInsert.setMobile(mMobile);
			imageInsert.setEmail(mEmail);
			imageInsert.setAudio(mAudioPath);

			if (imageDS.insert(imageInsert) == true) {
				Toast.makeText(this, "Successfully Saved.", Toast.LENGTH_LONG)
						.show();

				startActivity(new Intent(MeetingPlaceActivity.this,
						HomeActivity.class));
				finish();
			} else {
				Toast.makeText(this, "Not Saved.", Toast.LENGTH_LONG).show();

			}
		}

	}
}
