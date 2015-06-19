package com.ftfl.dhakaweather.util;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONWeatherParser {

	public List<DayForecast> mWeatherList = new ArrayList<DayForecast>();

	public WeatherForecast getForecastWeather(String data) throws JSONException {

		WeatherForecast forecast = new WeatherForecast();

		// create JSONObject from the data
		JSONObject jObj = new JSONObject(data);

		JSONArray jArr = jObj.getJSONArray(WeatherConstant.DAYLIST); // Here we
																		// have
																		// the
																		// forecast
		// for every day

		// We traverse all the array and parse the data
		for (int i = 0; i < jArr.length(); i++) {

			Long timestamp;
			float day, min, max, night, eve, morning;
			JSONObject jDayForecast = jArr.getJSONObject(i);

			// We retrieve the time stamp (dt)
			timestamp = jDayForecast.getLong(WeatherConstant.DAYTIME);

			// Temp is an object
			JSONObject jTempObj = jDayForecast
					.getJSONObject(WeatherConstant.TEMPERATURE);

			day = (float) jTempObj.getDouble(WeatherConstant.DAY);
			min = (float) jTempObj.getDouble(WeatherConstant.MINIMUM);
			max = (float) jTempObj.getDouble(WeatherConstant.MAXIMUM);
			night = (float) jTempObj.getDouble(WeatherConstant.NIGHT);
			eve = (float) jTempObj.getDouble(WeatherConstant.EVENING);
			morning = (float) jTempObj.getDouble(WeatherConstant.MORNING);

			mWeatherList.add(new DayForecast(timestamp, day, min, max, night,
					eve, morning));
		}
		return forecast;
	}
}
