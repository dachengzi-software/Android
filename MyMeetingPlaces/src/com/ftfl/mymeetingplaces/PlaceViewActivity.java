package com.ftfl.mymeetingplaces;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ftfl.mymeetingplaces.database.MeetingPlaceDataSource;
import com.ftfl.mymeetingplaces.util.MeetingPlace;
import com.ftfl.mymeetingplaces.util.MyMeetingPlacesConstants;

public class PlaceViewActivity extends Activity {

	TextView mTvRemarks = null;
	ImageView mViewImage = null;
	Button mBtnDelete = null;
	TextView mTvLat = null;
	TextView mTvLng = null;
	TextView mTvAudio = null;
	TextView mTvName = null;
	TextView mTvEmail = null;
	TextView mTvMobile = null;
	String mID = "";
	String mImagePath = "";
	String mAudioPath = "";
	String mRemarks = "";
	String mLatitude = "";
	String mLongitude = "";
	String mContactName = "";
	String mContactEmail = "";
	String mContactMobile = "";
	long mLID = 0;
	MeetingPlaceDataSource mMeetingPlaceDS = null;

	MeetingPlace mMeetingPlace = null;
	static final String AUDIO_DIRECTORY_NAME = "MeetingPlace Audios";
	static final int AUDIO_REQUEST = 5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_place_view);

		mTvRemarks = (TextView) findViewById(R.id.etViewRemark);
		mTvLat = (TextView) findViewById(R.id.tvViewLatitude);
		mTvLng = (TextView) findViewById(R.id.tvViewLongitude);
		mTvAudio = (TextView) findViewById(R.id.tvViewAudioFile);
		
		mTvName = (TextView) findViewById(R.id.tvViewName);
		mTvEmail = (TextView) findViewById(R.id.tvViewEmail);
		mTvMobile = (TextView) findViewById(R.id.tvViewMobile);
		
		mViewImage = (ImageView) findViewById(R.id.imageviewShowImageView);
		mMeetingPlaceDS = new MeetingPlaceDataSource(this);

		// get intent
		Intent mActivityIntent = getIntent();
		mID = mActivityIntent.getStringExtra(MyMeetingPlacesConstants.ID);
		mLID = Long.parseLong(mID);
		mMeetingPlace = mMeetingPlaceDS.singleVisitedPlaceData(mLID);

		mImagePath = mMeetingPlace.getFileName();
		mRemarks = mMeetingPlace.getDescription();
		mLatitude = mMeetingPlace.getLatitude();
		mLongitude = mMeetingPlace.getLongitude();
		mAudioPath = mMeetingPlace.getAudio();
		
		mContactName = mMeetingPlace.getName();
		mContactEmail = mMeetingPlace.getEmail();
		mContactMobile = mMeetingPlace.getMobile();

		mTvRemarks.setText(mRemarks);
		mTvLat.setText(mLatitude);
		mTvLng.setText(mLongitude);
		if(mAudioPath!="")
		mTvAudio.setText(mAudioPath);
		
		mTvName.setText(mContactName);
		mTvEmail.setText(mContactEmail);
		mTvMobile.setText(mContactMobile);
		
		// viewing Image
		if (mImagePath != null) {
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
				correctBmp = Bitmap.createBitmap(bmp1, 0, 0, bmp1.getWidth(),
						bmp1.getHeight(), mat, true);
			} catch (IOException e) {
				Log.w("TAG", "-- Error in setting image");
			} catch (OutOfMemoryError oom) {
				Log.w("TAG", "-- OOM Error in setting image");
			}
			mViewImage.setImageBitmap(correctBmp);
		}

		// Initialize alert box
		final String[] option = new String[] { "OK", "Cancel" };
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.select_dialog_item, option);
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		builder.setTitle("This Data Will delete Permanently");
		builder.setAdapter(adapter, new DialogInterface.OnClickListener() {

			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Log.e("Selected Item", String.valueOf(which));
				if (which == 0) {
					performDelete();
				}
				if (which == 1) {
					performCancel();
				}
			}
		});
		final AlertDialog dialog = builder.create();

		//mBtnDelete = (Button) findViewById(R.id.buttonDelete);
/*		mBtnDelete.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				dialog.show();
			}
		});*/

	}

	public void performUpdate(View v) {
		String description = mTvRemarks.getText().toString();

		if (mMeetingPlaceDS.updateData(mLID, description, mAudioPath)) {
			Toast.makeText(getApplicationContext(), "Successfully Updated",
					Toast.LENGTH_SHORT).show();
			Intent intent = new Intent();
			setResult(Activity.RESULT_OK, intent);
			finish();
		}

		else
			Toast.makeText(getApplicationContext(), "Not Updated",
					Toast.LENGTH_SHORT).show();

	}

	public void performDelete() {
		mMeetingPlaceDS.deleteData(mLID);
		File file = new File(mImagePath);
		if (file.exists())
			file.delete();
		Intent intent = new Intent();
		setResult(Activity.RESULT_OK, intent);
		finish();
	}

	public void performCancel() {
		Toast.makeText(getApplicationContext(), "Canceled.", Toast.LENGTH_SHORT)
				.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.place_view, menu);
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

	/*
	 * create file path for save audio file..
	 */
	/*private File createAudioFile() throws IOException {

		// External SD card location
		File mediaStorageDir = new File(
				Environment
						.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
				AUDIO_DIRECTORY_NAME);

		// Create the storage directory if it does not exist
		if (!mediaStorageDir.exists()) {
			if (!mediaStorageDir.mkdirs()) {
				return null;
			}
		}

		// Create an image file name
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
				Locale.getDefault()).format(new Date());
		String audioFileName = "AUDIO_" + timeStamp + "_";
		File audio = File.createTempFile(audioFileName,  prefix 
				".amr",  suffix 
				mediaStorageDir  directory 
		);

		mAudioPath = audio.getAbsolutePath();
		return audio;
	}
*/
	
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
	/**
	 * On activity result
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == AUDIO_REQUEST && resultCode == RESULT_OK) {
			
			Uri audioUri = data.getData();
			mAudioPath = getPath(audioUri);
			mTvAudio.setText(mAudioPath);
		}
	}
	
	public void performCall(View v)
	{
		Intent callIntent = new Intent(Intent.ACTION_CALL);
		callIntent.setData(Uri.parse("tel:" + mContactMobile));
		startActivity(callIntent);

	}
	
	public void performSms(View v)
	{
		Intent callIntent = new Intent(Intent.ACTION_SENDTO);
		callIntent.setData(Uri.parse("smsto:" + mContactMobile));
		startActivity(callIntent);
	}
	
	public void performEmail(View v)
	{
		   Intent email = new Intent(Intent.ACTION_SEND);

           email.putExtra(Intent.EXTRA_EMAIL, mContactEmail);
      /*     email.putExtra(Intent.EXTRA_CC, cc);
           email.putExtra(Intent.EXTRA_BCC, bcc);
           email.putExtra(Intent.EXTRA_SUBJECT, subject);
           email.putExtra(Intent.EXTRA_TEXT, message);*/

           // Use email client only
           email.setType("message/rfc822");
           startActivity(Intent.createChooser(email, "Choose an email client"));
	}
}
