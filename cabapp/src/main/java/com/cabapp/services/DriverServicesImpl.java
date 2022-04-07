package com.cabapp.services;

import java.util.List;

import com.cabapp.models.Details;
import com.cabapp.models.Driver;
import com.cabapp.models.Location;

public class DriverServicesImpl implements DriverServices {

	@Override
	public void changeStatus(Driver driver) {
		// TODO Auto-generated method stub

	}

	@Override
	public Driver addDriver(String driverName, Long phone, String address, String gender, Integer age, String regNumber,
			Location<Integer, Integer> location) {

		Details driverDetails_1 = new Details(driverName, phone, address, gender, age);
		Driver driver = new Driver(driverDetails_1, regNumber, location);

		return driver;
	}

	@Override
	public List<Driver> updateDriverLocation(List<Driver> driverList, String driverName,
			Location<Integer, Integer> destinationLocation) {
		for (Driver driver : driverList) {
			if(driver.getDetails().getName()==driverName) {
				driver.setLocation(destinationLocation);
			}
		}
		return driverList;
	}

	@Override
	public List<Driver> updateDriverIncome(List<Driver> driverList, String driverName, Integer bill) {
		for (Driver driver : driverList) {
			if(driver.getDetails().getName()==driverName) {
				driver.setIncome(bill);
			}
		}
		return driverList;

	}

	@Override
	public List<Driver> updateDriverStatus(List<Driver> driverList, String driverName, Boolean status) {
		for (Driver driver : driverList) {
			if(driver.getDetails().getName()==driverName) {
				driver.setStatus(status);
			}
		}
		return driverList;

	}

}
