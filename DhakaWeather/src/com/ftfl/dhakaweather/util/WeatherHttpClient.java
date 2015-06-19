package com.ftfl.dhakaweather.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherHttpClient {

	static String BASE_FORECAST_URL = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&q=";

	public String getForecastWeatherData(String location, String lang,
			String sForecastDayNum) {
		HttpURLConnection con = null;
		InputStream is = null;
		int forecastDayNum = Integer.parseInt(sForecastDayNum);

		try {

			// Forecast
			String url = BASE_FORECAST_URL + location;
			if (lang != null)
				url = url + "&lang=" + lang;

			url = url + "&units=metric&cnt=" + forecastDayNum;
			con = (HttpURLConnection) (new URL(url)).openConnection();
			con.setRequestMethod("GET");
			con.setDoInput(true);
			con.setDoOutput(true);
			con.connect();

			// Let's read the response
			StringBuffer buffer1 = new StringBuffer();
			is = con.getInputStream();
			BufferedReader br1 = new BufferedReader(new InputStreamReader(is));
			String line1 = null;
			while ((line1 = br1.readLine()) != null)
				buffer1.append(line1 + "\r\n");

			is.close();
			con.disconnect();

			System.out.println("Buffer [" + buffer1.toString() + "]");
			return buffer1.toString();
		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (Throwable t) {
			}
			try {
				con.disconnect();
			} catch (Throwable t) {
			}
		}
		return null;
	}
}
