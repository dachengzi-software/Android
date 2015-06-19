package com.ftfl.icareprofile;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.ftfl.icareprofile.adapter.CustomAdapter;
import com.ftfl.icareprofile.database.ICareDataSource;
import com.ftfl.icareprofile.utill.ICareProfile;

public class ICareProfileListActivity extends ActionBarActivity {

	ListView mListView = null;
	ICareProfile mCareProfile = null;
	List<ICareProfile> mProfileList = new ArrayList<ICareProfile>();
	//List<ICareProfile> mProfileNameList = new ArrayList<ICareProfile>();
	CustomAdapter adapter;

	Cursor mCursor;

	TextView mId_tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_icare_profile_list);

		/******** Take some data in Arraylist ( CustomListViewValuesArr ) ***********/
		setListData();
		mListView = (ListView) findViewById(R.id.icareProfileList);

		adapter = new CustomAdapter(ICareProfileListActivity.this, mProfileList);
		mListView.setAdapter(adapter);

		// OnCLickListiner For List Items
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent,
					android.view.View view, int position, long id) {

				mId_tv = (TextView) view.findViewById(R.id.id);
				String profileId_val = mId_tv.getText().toString(); // get id
																	// from text
																	// view

				/*
				 * create an intent and send data
				 */
				Intent mPreviewIntent = new Intent(getApplicationContext(),
						ICareProfilePreviewActivity.class);
				mPreviewIntent.putExtra("profileId", profileId_val);

				startActivity(mPreviewIntent);
			}
		});
	}

	/*
	 * set resume function of this activity.
	 */

	@Override
	public void onResume() {
		super.onResume();
		
		setListData(); 	
		//adapter.notifyDataSetChanged();// adapter will load with new data.
	}

	/*
	 * set value to the array list.
	 */
	public void setListData() 
	{
		ICareDataSource dataProfile = new ICareDataSource(ICareProfileListActivity.this);
		mProfileList.clear();
		mProfileList = dataProfile.iCareProfilesList();	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.icare_profile_list, menu);
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
