package com.cabapp;

import static org.junit.Assert.assertEquals;
//
import java.util.*;

import org.junit.Test;

import com.cabapp.models.Driver;
import com.cabapp.models.Location;
import com.cabapp.models.User;
import com.cabapp.services.DriverServices;
import com.cabapp.services.DriverServicesImpl;
import com.cabapp.services.UserServices;
import com.cabapp.services.UserServicesImpl;
import com.cabapp.utils.Utils;

public class MainTest {
	private List<User> usersList = new LinkedList<User>();
	private List<Driver> driversList = new LinkedList<Driver>();
	private UserServices userService = new UserServicesImpl();
	private DriverServices driverService = new DriverServicesImpl();
	private List<Driver> availableRides;

	@Test
	public void onboadingUsersTest() {

		Location<Integer, Integer> user_1_Location = new Location<Integer, Integer>(10, 40);

		User user_1 = userService.addUser("username_1", 9999999999L, null, "M", 24, user_1_Location);

		usersList.add(user_1);

		assertEquals(1, usersList.size());
	}

	@Test
	public void onBoardingDriversTest() {

		Location<Integer, Integer> driver_1_Location = new Location<Integer, Integer>(10, 45);
		Driver driver_1 = driverService.addDriver("drivername_1", 8888888888L, null, "M", 25, "LG4554K5",
				driver_1_Location);

		driversList.add(driver_1);

		assertEquals(1, driversList.size());

	}

	@Test
	public void getRideTest() {
		for (User user : usersList) {
			if (user.getUserDetails().getName().equals("user_1")) {
				availableRides = userService.findRide(user, driversList);
				assertEquals(1, availableRides.size());
			}
		}

	}

	@Test
	public void getEarningsTest() {
		Location<Integer, Integer> user_1_destination = new Location<Integer, Integer>(20, 5);
		for (User user : usersList) {
			if (user.getUserDetails().getName().equals("user_1")) {
				Driver choosenDriver = userService.chooseRide(availableRides, "drivername_1");
				int bill = Utils.calculateBill(user.getLocation(), user_1_destination);
				driversList = driverService.updateDriverIncome(driversList, choosenDriver.getDetails().getName(), bill);
				assertEquals(108L, (long) Utils.getApplicationTotalEarnings(driversList));
			}
		}

	}

}
