package com.ftfl.mymeetingplaces;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.ftfl.mymeetingplaces.adapter.CustomAdapter;
import com.ftfl.mymeetingplaces.database.MeetingPlaceDataSource;
import com.ftfl.mymeetingplaces.util.MeetingPlace;
import com.ftfl.mymeetingplaces.util.MyMeetingPlacesConstants;

public class MeetingPlaceListActivity extends Activity {

	MeetingPlaceDataSource mMeetingPlaceDS = null;
	List<MeetingPlace> mMeetingPlaces = new ArrayList<MeetingPlace>();
	List<String> mMeetingPlacesId = new ArrayList<String>();
	ListView mListView = null;
	CustomAdapter adapter = null;
	Location location = null;
	TextView mTvCurrentLat = null;
	TextView mTvCurrentLng = null;
	TextView mTvVisitedPlaceNo = null;
	int mPosition = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_meeting_place_list);

		mTvCurrentLat = (TextView) findViewById(R.id.currentLat);
		mTvCurrentLng = (TextView) findViewById(R.id.currentLng);
		mTvVisitedPlaceNo = (TextView) findViewById(R.id.tvVisitedPlacesNo);

		try {
			LocationManager locMgr = (LocationManager) this
					.getSystemService(Context.LOCATION_SERVICE);
			Criteria criteria = new Criteria();
			String locProvider = locMgr.getBestProvider(criteria, false);
			location = locMgr.getLastKnownLocation(locProvider);

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

			mTvCurrentLat.setText(latitude.toString());
			mTvCurrentLng.setText(longitude.toString());

		} catch (NullPointerException ne) {
			Log.e("Current Location", "Current Lat Lng is Null");
		} catch (Exception e) {
			e.printStackTrace();
		}

		mMeetingPlaceDS = new MeetingPlaceDataSource(this);
		mMeetingPlaces = mMeetingPlaceDS.meetingPlaceData();
		mMeetingPlacesId = mMeetingPlaceDS.meetingPlaceId();

		Integer intPlaceNo = mMeetingPlacesId.size();

		String strPlaceNo = "(" + intPlaceNo.toString() + ")";
		mTvVisitedPlaceNo.setText(strPlaceNo);

		Resources res = getResources();
		mListView = (ListView) findViewById(R.id.visitingPlaceList);
		adapter = new CustomAdapter(this, mMeetingPlaces, res, location);
		mListView.setAdapter(adapter);

		mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				mPosition = position;
				ImageView ivPlaceView = (ImageView) view
						.findViewById(R.id.ivArrow);

				ivPlaceView.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						showPlaceView(mPosition);
					}
				});

				ImageView ivPlaceViewCaptured = (ImageView) view
						.findViewById(R.id.ivListImage);

				ivPlaceViewCaptured
						.setOnClickListener(new View.OnClickListener() {
							public void onClick(View v) {
								showImage(mPosition);
							}
						});

				TextView tvAudio = (TextView) view
						.findViewById(R.id.tvListAudio);

				tvAudio
						.setOnClickListener(new View.OnClickListener() {
							public void onClick(View v) {
								playAudio(mPosition);
							}
						});
				
				LinearLayout layoutMap = (LinearLayout) view
						.findViewById(R.id.layoutMap);

				layoutMap
						.setOnClickListener(new View.OnClickListener() {
							public void onClick(View v) {
								showGoogleMap(mPosition);
							}
						});
			}
		});
	}

	public void showImage(int ePosition ) {
		MeetingPlace mMeetingPlace = mMeetingPlaces.get(ePosition);
		File imageFile = new File(mMeetingPlace.getFileName());
		Uri picUri = Uri.fromFile(imageFile);
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_VIEW);
		intent.setDataAndType(picUri, "image/*");
		startActivity(intent);
	}

	public void playAudio(int ePosition) {
		MeetingPlace mMeetingPlace = mMeetingPlaces.get(ePosition);
		
		String audioPath = null;
		audioPath= mMeetingPlace.getAudio();
		if(audioPath != null)
		{
			File audioFile = new File(audioPath);
			Uri audioUri = Uri.fromFile(audioFile);
			
			Intent intent = new Intent();
			intent.setAction(Intent.ACTION_VIEW);
			intent.setDataAndType(audioUri, "audio/*");
			startActivity(intent);
		}
	
	}
	
	public void showGoogleMap(int ePosition)
	{
		MeetingPlace mMeetingPlace = mMeetingPlaces.get(ePosition);
		
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("geo:0,0?q="
				+ ("" + mMeetingPlace.getLatitude() + "," + mMeetingPlace.getLongitude() + "")));
		try {
			startActivity(intent);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void showPlaceView(int ePosition) {
		Intent mEditIntent = new Intent(getApplicationContext(),
				PlaceViewActivity.class);

		mEditIntent.putExtra(MyMeetingPlacesConstants.ID,
				mMeetingPlacesId.get(ePosition));
		startActivityForResult(mEditIntent, MyMeetingPlacesConstants.UPDATE);
	}

	public void performHome(View v) {
		startActivity(new Intent(MeetingPlaceListActivity.this,
				HomeActivity.class));
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.visiting_place_list, menu);
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

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == MyMeetingPlacesConstants.UPDATE) {
			if (resultCode == Activity.RESULT_OK) {
				this.recreate();
			}
		}
	}
}
