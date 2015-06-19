package com.ftfl.profiledatabase;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.ftfl.icareprofile.R;
import com.ftfl.profiledatabase.adapter.CustomAdapter;
import com.ftfl.profiledatabase.database.ProfileDataSource;
import com.ftfl.profiledatabase.utill.Profile;
import com.ftfl.profiledatabase.utill.ProfileConstant;

public class ProfileListActivity extends ActionBarActivity {

	ListView mListView = null;
	Profile mCareProfile = null;
	List<Profile> mProfileList = new ArrayList<Profile>();
	CustomAdapter mAdapter;
	Cursor mCursor;
	TextView tvId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile_list);

		/******** Take some data in Arraylist ( CustomListViewValuesArr ) ***********/
		setListData();
		mListView = (ListView) findViewById(R.id.profileList);

		mAdapter = new CustomAdapter(ProfileListActivity.this, mProfileList);
		mListView.setAdapter(mAdapter);

		// OnCLickListiner For List Items
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent,
					android.view.View view, int position, long id) {

				tvId = (TextView) view.findViewById(R.id.tv_id);
				String profileId_val = tvId.getText().toString(); 

				/*
				 * create an intent and send data
				 */
				Intent mPreviewIntent = new Intent(getApplicationContext(),
						ProfilePreviewActivity.class);
				mPreviewIntent.putExtra(ProfileConstant.PROFILEID, profileId_val);

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
		mAdapter.notifyDataSetChanged();
	}

	/*
	 * set value to the array list.
	 */
	public void setListData() 
	{
		ProfileDataSource dataProfile = new ProfileDataSource(ProfileListActivity.this);
		mProfileList.clear();
		mProfileList = dataProfile.profilesList();	
	}
}
