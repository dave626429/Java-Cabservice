package com.cabapp.utils;

import java.util.List;

import com.cabapp.models.Driver;
import com.cabapp.models.Location;

public class Utils {

	private Utils() {}

	public static int calculateBill(Location<Integer,Integer> source,Location<Integer,Integer> destination) {
		int source_x=source.getX();
		int source_y=source.getY();
		int destination_x=destination.getX();
		int destination_y=destination.getY();

		int distance =(int) Math.sqrt(Math.pow((destination_x-source_x), 2)+Math.pow((destination_y-source_y),2));

		return (distance*3);
	}

	public static Long getApplicationTotalEarnings(List<Driver> driverList) {
		long earnings=0L;
		for (Driver driver : driverList) {
			earnings+=driver.getIncome();
		}
		return earnings;

	}

}
