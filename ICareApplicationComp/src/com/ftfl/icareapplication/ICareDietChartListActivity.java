package com.ftfl.icareapplication;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.ftfl.icareapplication.adapter.ActivityCustomAdapter;
import com.ftfl.icareapplication.database.ICareActivityDataSource;
import com.ftfl.icareapplication.utill.ICareActivityChart;

public class ICareDietChartListActivity extends Activity {
	ListView mActivityListView = null;
	ICareActivityChart mActivityChart = null;
	List<ICareActivityChart> mActivityList = new ArrayList<ICareActivityChart>();
	public ArrayList<ICareActivityChart> mActivitiesList = new ArrayList<ICareActivityChart>();
	ActivityCustomAdapter activityAdapter;
	ICareDietChartListActivity mActivityCustomAdapter = null;
	TextView mTvId = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_icare_diet_chart_list);
		mActivityCustomAdapter = this;
		/******** Take some data in Arraylist ( CustomListViewValuesArr ) ***********/
		setActivityListData();
		Resources activityResource = getResources();
		mActivityListView = (ListView) findViewById(R.id.iCareCustomActivityList);

		activityAdapter = new ActivityCustomAdapter(mActivityCustomAdapter,
				mActivitiesList, activityResource);
		mActivityListView.setAdapter(activityAdapter);

		// OnCLickListiner For List Items
		mActivityListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent,
					android.view.View view, int position, long id) {

				mTvId = (TextView) view.findViewById(R.id.db_activity_id);
				String activityIdValue = mTvId.getText().toString(); // get id
																		// from
																		// text
				/*
				 * create an intent and send data
				 */
				Intent mPreviewIntent = new Intent(getApplicationContext(),
						ICareDietChartPreviewActivity.class);
				mPreviewIntent.putExtra("activityId", activityIdValue);
				startActivity(mPreviewIntent);
			}
		});
	}
	
	@Override
	public void onResume() {
		super.onResume();
		mActivitiesList.clear();// clear the object list
		setActivityListData(); // set updated object list
		activityAdapter.notifyDataSetChanged(); // if any change occour to the
												// adapter adapter will load
												// with new data.
	}
	
	public void setActivityListData() {
		ICareActivityDataSource activityData = new ICareActivityDataSource(this);
		mActivityList = activityData.iCareActivityList();
		for (int i = 0; i < mActivityList.size(); i++) {
			ICareActivityChart mActivity = mActivityList.get(i);
			mActivitiesList.add(mActivity);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.icare_diet_chart_list, menu);
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
