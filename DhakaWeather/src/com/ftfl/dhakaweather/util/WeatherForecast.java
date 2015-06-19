package com.ftfl.dhakaweather.util;

import java.util.ArrayList;
import java.util.List;


public class WeatherForecast {

	List<DayForecast> daysForecast = new ArrayList<DayForecast>();
	List<DayForecast> weatherList = new ArrayList<DayForecast>();
	public void addForecast(DayForecast forecast) {
		daysForecast.add(forecast);
		System.out.println("Add forecast ["+forecast+"]");
	}
	public DayForecast getForecast(int dayNum) {
		return daysForecast.get(dayNum);
	}
}
