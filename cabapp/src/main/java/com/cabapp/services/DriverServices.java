package com.cabapp.services;

import java.util.List;

import com.cabapp.models.Driver;
import com.cabapp.models.Location;

public interface DriverServices {
	public void changeStatus(Driver driver);
	public Driver addDriver(String driverName, Long phone, String address, String gender, Integer age,String regNumber,Location<Integer,Integer> location);
	public List<Driver> updateDriverLocation(List<Driver> driverList, String driverName,Location<Integer,Integer> destinationLocation);
	public List<Driver> updateDriverIncome(List<Driver> driverList, String driverName,Integer bill);
	public List<Driver> updateDriverStatus(List<Driver> driverList, String driverName,Boolean status);

}
