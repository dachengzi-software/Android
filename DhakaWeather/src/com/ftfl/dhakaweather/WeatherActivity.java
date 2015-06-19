package com.ftfl.dhakaweather;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.ftfl.dhakaweather.adapter.CustomAdapter;
import com.ftfl.dhakaweather.util.DayForecast;
import com.ftfl.dhakaweather.util.JSONWeatherParser;
import com.ftfl.dhakaweather.util.WeatherConstant;
import com.ftfl.dhakaweather.util.WeatherForecast;
import com.ftfl.dhakaweather.util.WeatherHttpClient;

public class WeatherActivity extends ActionBarActivity {

	ProgressBar mProgressBar;
	String mForecastDaysNum = "3";
	ToggleButton mToggle = null;

	ListView mListView = null;
	DayForecast mForcast = null;
	List<DayForecast> mForecastList = new ArrayList<DayForecast>();
	ArrayList<DayForecast> mWeatherForcastList = new ArrayList<DayForecast>();
	CustomAdapter mAdapter;
	WeatherActivity mCareCustomAdapter = null;
	Toast toast;
	LinearLayout mLayout = null;
	LinearLayout mLayoutTwo = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weather);

		mLayout = (LinearLayout) findViewById(R.id.internet_yes);
		mLayoutTwo = (LinearLayout) findViewById(R.id.internet_not);
		mProgressBar = (ProgressBar) findViewById(R.id.progressBar1);
		mProgressBar.setVisibility(View.VISIBLE);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		mCareCustomAdapter = this;

		String city = "DHAKA, BD";
		String lang = "en";
		if (isNetworkAvailable()) {
			mLayoutTwo.setVisibility(View.GONE);
			JSONForecastWeatherTask task1 = new JSONForecastWeatherTask();
			task1.execute(new String[] { city, lang, mForecastDaysNum });
		} else {
			mLayout.setVisibility(View.GONE);
			toast = Toast.makeText(this, "Internet Connection Required....",
					Toast.LENGTH_LONG);
			toast.show();
		}
	}

	private boolean isNetworkAvailable() {
		ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetworkInfo = connectivityManager
				.getActiveNetworkInfo();
		return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		if (WeatherConstant.CHECK  == 0)
			getMenuInflater().inflate(R.menu.weather_two, menu);
		else
			getMenuInflater().inflate(R.menu.weather, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {

		case R.id.celsius:

			if (WeatherConstant.CHECK  == 0)
				WeatherConstant.CHECK  = 1;
			else
				WeatherConstant.CHECK  = 0;
			startActivity(new Intent(WeatherActivity.this,
					WeatherActivity.class));
			finish();

			return true;

		case R.id.refresh:

			startActivity(new Intent(WeatherActivity.this,
					WeatherActivity.class));
			finish();
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private class JSONForecastWeatherTask extends
			AsyncTask<String, Void, WeatherForecast> {
		// ProgressDialog progressDialog = null;

		@Override
		protected void onPreExecute() {
			// progressDialog= ProgressDialog.show(MainActivity.this,
			// "Progress Dialog Title Text","Process Description Text", true);

		}

		@Override
		protected WeatherForecast doInBackground(String... params) {

			String data = ((new WeatherHttpClient()).getForecastWeatherData(
					params[0], params[1], params[2]));
			WeatherForecast forecast = new WeatherForecast();
			JSONWeatherParser mParser = new JSONWeatherParser();
			try {
				forecast = mParser.getForecastWeather(data);
				mForecastList = mParser.mWeatherList;
				System.out.println("Weather [" + forecast + "]");
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return forecast;

		}

		@Override
		protected void onPostExecute(WeatherForecast forecastWeather) {
			super.onPostExecute(forecastWeather);
			mProgressBar.setVisibility(View.GONE);

			for (int i = 0; i < mForecastList.size(); i++) {
				DayForecast mWeather = mForecastList.get(i);
				mWeatherForcastList.add(mWeather);
			}

			Resources res = getResources();
			mListView = (ListView) findViewById(R.id.weather_list);

			mAdapter = new CustomAdapter(mCareCustomAdapter,
					mWeatherForcastList, res);
			mListView.setAdapter(mAdapter);
		}
	}
}
