package com.thinkifylab.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thinkifylab.demo.entity.Driver;
import com.thinkifylab.demo.entity.Location;
import com.thinkifylab.demo.repository.DriverRepository;
import com.thinkifylab.demo.service.DriverService;

@RestController
@RequestMapping(path = "/apis_v1/drivers")
public class DriverController {
	@Autowired
	DriverService driverSerive;

	// Testing Scope begin
	@Autowired
	DriverRepository driverRepo;

	@GetMapping(path = "/{id}")
	public Optional<Driver> getDriver(@PathVariable Long id) {
		Optional<Driver> response = driverRepo.findById(id);
		System.out.println(response);
		return response;
	}

	@GetMapping(path = "/")
	public List<Driver> getDrivers() {
		List<Driver> response = driverRepo.findAll();
		System.out.println(response);
		return response;
	}
	// Testing Scope end

	@PutMapping(path = "/location/{id}")
	public Driver updateLocation(@PathVariable Long id, @RequestBody Location<Long, Long> destination,
			@RequestParam(name = "withuser", defaultValue = "false") Boolean withUser) {
		return driverSerive.updateDriverLocation(id, destination, withUser);
	}

	@PutMapping(path = "/status/{id}")
	public Driver updateStatus(@PathVariable Long id, @RequestParam(name = "currentstatus") Boolean currentStatus) {
		return driverSerive.updateDriveStatus(id, currentStatus);
	}

	@PostMapping(path = "/adddriver")
	public Driver addDriver(@RequestBody Driver driver) {
		System.out.println(driver);
		return driverSerive.addDriver(driver);
	}

	@PostMapping(path = "/adddrivers")
	public List<Driver> addDrivers(@RequestBody List<Driver> drivers) {
		return driverSerive.addDrivers(drivers);
	}
}
