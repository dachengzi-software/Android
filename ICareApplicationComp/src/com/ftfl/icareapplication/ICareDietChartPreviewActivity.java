package com.ftfl.icareapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.ftfl.icareapplication.database.ICareActivityDataSource;
import com.ftfl.icareapplication.utill.ICareActivityChart;

public class ICareDietChartPreviewActivity extends Activity {
	TextView mTvDate = null;
	TextView mTvTime = null;
	TextView mTvName = null;
	TextView mTvDescription = null;
	TextView mTvCurrentDate = null;
	//TextView mTvAlarm = null;

	String mStrActivityID = null;
	long mActivityId = 0;
	ICareActivityChart mUpdateActivity = null;
	ICareActivityDataSource mActivityDataSource = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_icare_diet_chart_preview);
		
		/*
		 * set view
		 */
		mTvDate = (TextView) findViewById(R.id.db_two_activity_date);
		mTvTime = (TextView) findViewById(R.id.db_two_activity_time);
		mTvName = (TextView) findViewById(R.id.db_two_activity_name);
		mTvDescription = (TextView) findViewById(R.id.db_two_activity_description);
		mTvCurrentDate = (TextView) findViewById(R.id.db_two_activity_current_date);
		//mTvAlarm = (TextView) findViewById(R.id.db_two_activity_alarm);

		/*
		 * Get data from intent
		 */

		Intent mIntent = getIntent();
		mStrActivityID = mIntent.getStringExtra("activityId");
		mActivityId = Long.parseLong(mStrActivityID);

		/*
		 * view text
		 */
		showText(mActivityId);
	}
	
	public void showText(long eProfileId) {

		/*
		 * get the profile which include all data from database according
		 * profileId of the clicked item.
		 */
		mActivityDataSource = new ICareActivityDataSource(this);
		mUpdateActivity = mActivityDataSource.updateActivityData(mActivityId);

		String mDate = mUpdateActivity.getDate();
		String mTime = mUpdateActivity.getTime();
		String mName = mUpdateActivity.getName();
		String mDescription = mUpdateActivity.getActivityDescription();
		String mCurrentDate = mUpdateActivity.getCurrentDate();
		//String mAlarm = mUpdateActivity.getAlarm();

		/*
		 * Set the data of database to the TextView
		 */

		mTvDate.setText(mDate);
		mTvTime.setText(mTime);
		mTvName.setText(mName);
		mTvDescription.setText(mDescription);
		mTvCurrentDate.setText(mCurrentDate);
		//mTvAlarm.setText(mAlarm);
	}
	
	public void editData(View v)
	{
		Intent mEditIntent = new Intent(getApplicationContext(),
				ICareCreateDietChartActivity.class);
		mEditIntent.putExtra("activityId", mStrActivityID);
		// startActivity(mEditIntent);
		startActivityForResult(mEditIntent, 2);
	}
	
	public void deleteData(View v)
	{
		mActivityDataSource = new ICareActivityDataSource(this);
		mActivityDataSource.deleteData(mActivityId);
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.icare_diet_chart_preview, menu);
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
	
	/*
	 * when return back in this activity from previously started activity this method is work.
	 */
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 2) {
			if (resultCode == Activity.RESULT_OK) {
				Bundle b = data.getExtras();
				if (b != null) {
					mStrActivityID = (String) b.getSerializable("activityID");
					mActivityId = Long.parseLong(mStrActivityID);
					mActivityDataSource = new ICareActivityDataSource(this);
					mUpdateActivity = mActivityDataSource
							.updateActivityData(mActivityId);
					showText(mActivityId);
				}
			} else if (resultCode == 0) {
				System.out.println("RESULT CANCELLED");
			}
		}
	}
}
