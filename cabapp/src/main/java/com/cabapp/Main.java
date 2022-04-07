package com.cabapp;

import java.util.*;
import com.cabapp.models.Driver;
import com.cabapp.models.Location;
import com.cabapp.models.User;
import com.cabapp.services.DriverServices;
import com.cabapp.services.DriverServicesImpl;
import com.cabapp.services.UserServices;
import com.cabapp.services.UserServicesImpl;
import com.cabapp.utils.Utils;

public class Main {

	public static void main(String[] args) {

		UserServices userService = new UserServicesImpl();
		DriverServices driverService = new DriverServicesImpl();

		Location<Integer, Integer> user_1_Location = new Location<Integer, Integer>(10, 40);
		User user_1 = userService.addUser("username_1", 9999999999L, null, "M", 24, user_1_Location);
		Location<Integer, Integer> user_1_destination = new Location<Integer, Integer>(20, 5);

		Location<Integer, Integer> driver_1_Location = new Location<Integer, Integer>(10, 45);
		Location<Integer, Integer> driver_2_Location = new Location<Integer, Integer>(4, 45);
		Location<Integer, Integer> driver_3_Location = new Location<Integer, Integer>(20, 5);
		Location<Integer, Integer> driver_4_Location = new Location<Integer, Integer>(100, 7);
		Location<Integer, Integer> driver_5_Location = new Location<Integer, Integer>(25, 45);
		Location<Integer, Integer> driver_6_Location = new Location<Integer, Integer>(60, 20);

		Driver driver_1 = driverService.addDriver("drivername_1", 8888888888L, null, "M", 25, "LG4554K5",
				driver_1_Location);
		Driver driver_2 = driverService.addDriver("drivername_2", 4444444444L, null, "F", 40, "BG4554K5",
				driver_2_Location);
		Driver driver_3 = driverService.addDriver("drivername_3", 7777777777L, null, "F", 23, "BD4554K5",
				driver_3_Location);
		Driver driver_4 = driverService.addDriver("drivername_4", 9999988888L, null, "F", 50, "AG4554K5",
				driver_4_Location);
		Driver driver_5 = driverService.addDriver("drivername_5", 8888855888L, null, "M", 25, "NS4554K5",
				driver_5_Location);
		Driver driver_6 = driverService.addDriver("drivername_6", 2333334455L, null, "F", 29, "CG45S4K5",
				driver_6_Location);

		List<Driver> driverList = new ArrayList<Driver>();
		driverList.add(driver_1);
		driverList.add(driver_2);
		driverList.add(driver_3);
		driverList.add(driver_4);
		driverList.add(driver_5);
		driverList.add(driver_6);

		List<Driver> availableRides = userService.findRide(user_1, driverList);
		Driver choosenDriver = userService.chooseRide(availableRides, "drivername_1");
		int bill =Utils.calculateBill(user_1.getLocation(), user_1_destination);
		
		user_1=userService.updateUserLocation(user_1, user_1_destination);
		
		driverList=driverService.updateDriverLocation(driverList, choosenDriver.getDetails().getName(), user_1_destination);
		driverList=driverService.updateDriverIncome(driverList, choosenDriver.getDetails().getName(), bill);
		driverList=driverService.updateDriverStatus(driverList, choosenDriver.getDetails().getName(), false);
		
		System.out.println(Utils.getApplicationTotalEarnings(driverList));
		
	}

}
