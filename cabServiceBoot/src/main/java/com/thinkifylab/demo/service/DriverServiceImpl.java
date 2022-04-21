package com.thinkifylab.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thinkifylab.demo.entity.Driver;
import com.thinkifylab.demo.entity.Location;
import com.thinkifylab.demo.repository.DriverRepository;
import com.thinkifylab.demo.util.Utils;

@Component
public class DriverServiceImpl implements DriverService {

	@Autowired
	DriverRepository repo;

	@Override
	public Driver addDriver(Driver driver) {
		try {
			return repo.save(driver);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Driver> addDrivers(List<Driver> drivers) {
		try {
			return repo.saveAll(drivers);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Driver updateDriverLocation(Long driverId, Location<Long, Long> destination, Boolean withUser) {
		try {
			Driver driver = repo.findById(driverId).orElse(null);

			/*
			 * 1.When driver traveling with user 2.Distance for traveling to user is
			 * excluded
			 */
			if (withUser) {
				Integer fare = Utils.calculateBill(driver.getLocation(), destination);
				driver.setIncome(driver.getIncome() + fare);
			}

			driver.setLocation(destination);
			repo.save(driver);
			return driver;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Driver updateDriveStatus(Long driverId, Boolean newStatus) {
		try {
			Driver driver = repo.findById(driverId).orElse(null);
			driver.setStatus(newStatus);
			repo.save(driver);
			return driver;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Driver> findDriversTotalEarnings() {
		try {
			List<Driver> drivers = repo.findAll();
			return drivers;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
