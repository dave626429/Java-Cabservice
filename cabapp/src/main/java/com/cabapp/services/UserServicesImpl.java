package com.cabapp.services;

import java.util.ArrayList;
import java.util.List;

import com.cabapp.models.Details;
import com.cabapp.models.Driver;
import com.cabapp.models.Location;
import com.cabapp.models.User;

public class UserServicesImpl implements UserServices {

	@Override
	public Driver chooseRide(List<Driver> list, String driverName) {
		try {
			for (Driver driver : list) {
				if (driver.getDetails().getName() == driverName) {
					return driver;
				}
			}
			throw new RuntimeException("Selected driver not found.");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}

	}

	@Override
	public List<Driver> findRide(User user, List<Driver> driverList) {

		try {
			int user_x = user.getLocation().getX();
			int user_y = user.getLocation().getY();
			List<Driver> availableDriver = new ArrayList<>();

			for (Driver driver : driverList) {
				int driver_x = driver.getLocation().getX();
				int driver_y = driver.getLocation().getY();

				if ((((user_x >= driver_x) ? (user_x - driver_x) <= 5 : (driver_x - user_x) <= 5)
						&& ((user_y >= driver_y) ? (user_y - driver_y) <= 5 : (driver_y - user_y) <= 5)) && driver.getStatus()!=false) {

					availableDriver.add(driver);
				}

			}
			if (availableDriver.size() == 0) {
				throw new RuntimeException(" No ride found.");
			}
			return availableDriver;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}

	}

	@Override
	public User addUser(String username, Long phone, String address, String gender, Integer age,
			Location<Integer, Integer> location) {
		Details userDetails = new Details(username, phone, address, gender, age);
		User user = new User(userDetails, location);
		return user;
	}

	@Override
	public User updateUserLocation(User user, Location<Integer, Integer> destinationLocation) {
		user.setLocation(destinationLocation);
		return user;
	}

}
