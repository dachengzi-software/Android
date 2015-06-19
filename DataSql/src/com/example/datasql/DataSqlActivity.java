package com.example.datasql;

import java.util.ArrayList;

import com.example.datasql.database.DBHelper;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DataSqlActivity extends Activity {

	public final static String EXTRA_MESSAGE = "com.example.DataSql.MESSAGE";

	private ListView mListView;
	DBHelper mdbHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_data_sql);

		mdbHelper = new DBHelper(this);

		ArrayList<String> array_list = mdbHelper.getAllCotacts();

		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, array_list);

		// adding it to the list view.
		mListView = (ListView) findViewById(R.id.listView1);
		mListView.setAdapter(arrayAdapter);

		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				/**
				 * this will not work for edit and delete, if you don't delete
				 * it sequentially
				 */
				int id_To_Search = arg2 + 1;

				Bundle dataBundle = new Bundle();
				dataBundle.putInt("id", id_To_Search);
				Intent intent = new Intent(getApplicationContext(),
						DisplayContactActivity.class);
				intent.putExtras(dataBundle);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.data_sql, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);
		switch (item.getItemId()) {
		case R.id.item1:
			Bundle dataBundle = new Bundle();
			dataBundle.putInt("id", 0);
			Intent intent = new Intent(getApplicationContext(),
					DisplayContactActivity.class);
			intent.putExtras(dataBundle);
			startActivity(intent);
			return true;
		default:
			return super.onOptionsItemSelected(item);

		}
	}

	public boolean onKeyDown(int keycode, KeyEvent event) {
		if (keycode == KeyEvent.KEYCODE_BACK) {
			moveTaskToBack(true);
		}
		return super.onKeyDown(keycode, event);
	}
}
