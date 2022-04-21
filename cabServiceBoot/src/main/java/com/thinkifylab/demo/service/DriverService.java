package com.thinkifylab.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thinkifylab.demo.entity.Driver;
import com.thinkifylab.demo.entity.Location;

@Service
public interface DriverService {
	public Driver addDriver(Driver driver);
	public List<Driver> addDrivers(List<Driver> drivers);
	public Driver updateDriverLocation(Long driverId, Location<Long,Long> destination,Boolean withUse);
	public Driver updateDriveStatus(Long driverId,Boolean newStatus);
	public List<Driver> findDriversTotalEarnings();
	
}
