package com.thinkifylab.demo.util;

import java.util.List;

import com.thinkifylab.demo.entity.Driver;
import com.thinkifylab.demo.entity.Location;

public class Utils {
	private Utils() {}

	public static Integer calculateBill(Location<Long,Long> source,Location<Long,Long> destination) {
		Long source_x=source.getX();
		Long source_y=source.getY();
		Long destination_x=destination.getX();
		Long destination_y=destination.getY();

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
