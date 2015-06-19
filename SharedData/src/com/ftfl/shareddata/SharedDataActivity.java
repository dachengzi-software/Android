package com.ftfl.shareddata;

import java.util.ArrayList;
import java.util.List;

import com.ftfl.shareddata.constants.FTFLConstants;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SharedDataActivity extends ActionBarActivity {
	
	String[] mName = {
		"Shuvo", "Nasser"	
	};
	
	SharedPreferences sPrefs = null;
	ListView mListView = null;
	List<String> mNameList = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shared_data);
		
		sPrefs = getSharedPreferences(FTFLConstants.MY_PREFERENCES, Context.MODE_PRIVATE);
		
		Editor sEdit = sPrefs.edit();
	
		sEdit.putString(FTFLConstants.PROFILE_KEY, mName[0]);
		sEdit.putString(FTFLConstants.PROFILE_KEY1, mName[1]);
		sEdit.commit();
		
		
		String mNameRead = sPrefs.getString(FTFLConstants.PROFILE_KEY, "");
		String mNameReadTwo = sPrefs.getString(FTFLConstants.PROFILE_KEY1, "");
		mNameList.add(mNameReadTwo);
		mNameList.add(mNameRead);
		
		mListView = (ListView) findViewById(R.id.listView);
		 ArrayAdapter<String> mProfileAdapter = new ArrayAdapter<String>(this,
			        android.R.layout.simple_list_item_1, mNameList);
		 mListView.setAdapter(mProfileAdapter);
	}

}
