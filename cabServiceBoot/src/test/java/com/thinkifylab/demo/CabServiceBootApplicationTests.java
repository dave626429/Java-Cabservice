package com.thinkifylab.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thinkifylab.demo.entity.Details;
import com.thinkifylab.demo.entity.Driver;
import com.thinkifylab.demo.entity.Location;
import com.thinkifylab.demo.entity.User;
import com.thinkifylab.demo.service.DriverService;
import com.thinkifylab.demo.service.UserService;

@SpringBootTest
class CabServiceBootApplicationTests {

	@Autowired
	UserService userService;
	
	@Autowired
	DriverService driverService;

	@Test
	public void addUser() {
		User user= new User();
		Location<Long,Long> location= new Location<>();
		Details details= new Details();
		location.setX(0L);
		location.setY(14L);
		details.setName("User_1");
		details.setGender("M");
		details.setAge(30);
		details.setPhone(9999999999L);
		user.setLocation(location);
		user.setDetails(details);

		assertNotNull(userService.addUser(user));

	}
	
	@Test
	public void findRide() {	
		Driver driver_1= new Driver();
		Location<Long,Long> location_1= new Location<>();
		Details details_1= new Details();
		location_1.setX(0L);
		location_1.setY(3L);
		details_1.setName("Driver_3");
		details_1.setGender("TG");
		details_1.setAge(23);
		details_1.setPhone(1111111111L);
		driver_1.setLocation(location_1);
		driver_1.setDetails(details_1);
		driver_1.setRegistrationNumber("BXV-2256X");
		driver_1.setCarModel("Swift-X");
		driver_1.setStatus(false);
		
		Driver driver_2= new Driver();
		Location<Long,Long> location_2= new Location<>();
		Details details_2= new Details();
		location_2.setX(0L);
		location_2.setY(4L);
		details_2.setName("Driver_4");
		details_2.setGender("M");
		details_2.setAge(30);
		details_2.setPhone(222222222L);
		driver_2.setLocation(location_2);
		driver_2.setDetails(details_2);
		driver_2.setRegistrationNumber("BXV-2256X");
		driver_2.setCarModel("Swift-X");
		driver_2.setStatus(true);
		
		driverService.addDriver(driver_1);
		driverService.addDriver(driver_2);
		
		List<Driver> list=userService.findRide(1L, 2L);
		
		assertEquals(1, list.size()); 
		
	}
	
	@Test
	public void chooseRide() {
		Driver driver_1= new Driver();
		Location<Long,Long> location_1= new Location<>();
		Details details_1= new Details();
		location_1.setX(0L);
		location_1.setY(3L);
		details_1.setName("Driver_5");
		details_1.setGender("TG");
		details_1.setAge(23);
		details_1.setPhone(1111111111L);
		driver_1.setLocation(location_1);
		driver_1.setDetails(details_1);
		driver_1.setRegistrationNumber("BXV-2256X");
		driver_1.setCarModel("Swift-X");
		driver_1.setStatus(true);
		
		Driver driver_2= new Driver();
		Location<Long,Long> location_2= new Location<>();
		Details details_2= new Details();
		location_2.setX(0L);
		location_2.setY(4L);
		details_2.setName("Driver_6");
		details_2.setGender("M");
		details_2.setAge(30);
		details_2.setPhone(222222222L);
		driver_2.setLocation(location_2);
		driver_2.setDetails(details_2);
		driver_2.setRegistrationNumber("BXV-2256X");
		driver_2.setCarModel("Swift-X");
		driver_2.setStatus(true);
		
		driverService.addDriver(driver_1);
		driverService.addDriver(driver_2);
		
		List<Driver> list=userService.findRide(1L, 2L);
		
		assertNotNull(userService.chooseRide(list.get(0).getId()));
	}
	
	@Test
	public void updateUserLocation() {
		User user= new User();
		Location<Long,Long> location= new Location<>();
		Details details= new Details();
		location.setX(0L);
		location.setY(14L);
		details.setName("User_2");
		details.setGender("M");
		details.setAge(30);
		details.setPhone(9999999999L);
		user.setLocation(location);
		user.setDetails(details);
		
		Location<Long,Long> newlocation=new Location<>();
		newlocation.setX(15L);
		newlocation.setY(100L);
		
		User userDb= userService.addUser(user);
		
		User UserDbUpdated=userService.updateUserLocation(userDb.getId(), newlocation);
		
		assertEquals(15L,UserDbUpdated.getLocation().getX());
		assertEquals(100L,UserDbUpdated.getLocation().getY());
		
	}
	
	
	/* 
	 * DriverService
	 **/
	@Test
	public void addDriver() {
		Driver driver= new Driver();
		Location<Long,Long> location= new Location<>();
		Details details= new Details();
		location.setX(0L);
		location.setY(14L);
		details.setName("Driver_1");
		details.setGender("M");
		details.setAge(26);
		details.setPhone(8888888888L);
		driver.setLocation(location);
		driver.setDetails(details);
		driver.setRegistrationNumber("BXV-2256X");
		driver.setCarModel("Swift-X");
		
		assertNotNull(driverService.addDriver(driver));
	
	}
	
	@Test
	public void updateDriverLocation() {
		Driver driver= new Driver();
		Location<Long,Long> location= new Location<>();
		Details details= new Details();
		location.setX(100L);
		location.setY(4L);
		details.setName("Driver_2");
		details.setGender("F");
		details.setAge(28);
		details.setPhone(8777777777L);
		driver.setLocation(location);
		driver.setDetails(details);
		driver.setRegistrationNumber("BXV-2256X");
		driver.setCarModel("Swift-X");
		
		Location<Long,Long> destination= new Location<>();
		destination.setX(10L);
		destination.setY(10L);
		
		Driver driverDb=driverService.addDriver(driver);
		Boolean withUser=false;
		
		Driver driverDbUpdated=driverService.updateDriverLocation(driverDb.getId(),destination,withUser);
		
		assertEquals(10L,driverDbUpdated.getLocation().getX());
		assertEquals(10L,driverDbUpdated.getLocation().getY());

	}

	@Test
	public void updateDriveStatus() {
		Driver driver= new Driver();
		Location<Long,Long> location= new Location<>();
		Details details= new Details();
		location.setX(100L);
		location.setY(4L);
		details.setName("Driver_10");
		details.setGender("F");
		details.setAge(24);
		details.setPhone(8777777777L);
		driver.setLocation(location);
		driver.setDetails(details);
		driver.setRegistrationNumber("BXV-2256X");
		driver.setCarModel("Swift-X");
		
		Driver driverDb=driverService.addDriver(driver);
		
		Driver driverDbUpdated=driverService.updateDriveStatus(driverDb.getId(), false);
		
		assertEquals(false,driverDbUpdated.getStatus());
	}
	
//	@Test
//	public void findDriversTotalEarnings() {
//		Driver driver_1= new Driver();
//		Location<Long,Long> location_1= new Location<>();
//		Details details_1= new Details();
//		location_1.setX(0L);
//		location_1.setY(3L);
//		details_1.setName("Driver_11");
//		details_1.setGender("TG");
//		details_1.setAge(23);
//		details_1.setPhone(1111111111L);
//		driver_1.setLocation(location_1);
//		driver_1.setDetails(details_1);
//		driver_1.setRegistrationNumber("BXV-2256X");
//		driver_1.setCarModel("Swift-X");
//		driver_1.setStatus(true);
//		
//		Driver driver_2= new Driver();
//		Location<Long,Long> location_2= new Location<>();
//		Details details_2= new Details();
//		location_2.setX(0L);
//		location_2.setY(4L);
//		details_2.setName("Driver_12");
//		details_2.setGender("M");
//		details_2.setAge(30);
//		details_2.setPhone(222222222L);
//		driver_2.setLocation(location_2);
//		driver_2.setDetails(details_2);
//		driver_2.setRegistrationNumber("BXV-2256X");
//		driver_2.setCarModel("Swift-X");
//		driver_2.setStatus(true);
//		
//		driverService.addDriver(driver_1);
//		driverService.addDriver(driver_2);
//		
//		List<Driver> drivers=driverService.findDriversTotalEarnings();
//		
//		assertEquals(2,drivers.size());
//	}
}


