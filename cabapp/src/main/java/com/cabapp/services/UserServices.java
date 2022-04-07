package com.cabapp.services;

import java.util.List;

import com.cabapp.models.Driver;
import com.cabapp.models.Location;
import com.cabapp.models.User;

public interface UserServices {
	public User addUser(String username,Long phone,String address,String gender,Integer age, Location<Integer,Integer> location);
	public List<Driver> findRide(User user, List<Driver> driverList);
	public Driver chooseRide(List<Driver> list,String driverName);
	public User updateUserLocation(User user, Location<Integer,Integer> destinationLocation);
}
