package com.thinkifylab.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thinkifylab.demo.entity.Driver;
import com.thinkifylab.demo.entity.Location;
import com.thinkifylab.demo.entity.User;
import com.thinkifylab.demo.exception.NoRideFoundException;
import com.thinkifylab.demo.repository.DriverRepository;
import com.thinkifylab.demo.repository.UserRepository;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	DriverRepository driverRepo;

	@Override
	public User addUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public List<User> addUsers(List<User> users) {
		return userRepo.saveAll(users);
	}

	@Override
	public List<Driver> findRide(Long user_x, Long user_y) {
		try {
			List<Driver> availableDrivers = driverRepo.findByStatus(true);

			List<Driver> availableDriversAtLocation = new ArrayList<>();

			availableDrivers.forEach((driver) -> {
				Long driver_x = driver.getLocation().getX();
				Long driver_y = driver.getLocation().getY();

				if ((((user_x >= driver_x) ? (user_x - driver_x) <= 5 : (driver_x - user_x) <= 5)
						&& ((user_y >= driver_y) ? (user_y - driver_y) <= 5 : (driver_y - user_y) <= 5))
						&& driver.getStatus() != false) {

					availableDriversAtLocation.add(driver);
				}
			});

			if (availableDriversAtLocation.size() == 0)
				throw new NoRideFoundException("No driver available currently.");

			return availableDriversAtLocation;
		} catch (Exception e) {
//			e.printStackTrace();
			System.err.println(e.getMessage());
			return new ArrayList<Driver>();
		}

	}

	@Override
	public Optional<Driver> chooseRide(Long id) {
		try {
			Optional<Driver> choosenDriver = driverRepo.findById(id);
			return choosenDriver;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public User updateUserLocation(Long userID, Location<Long, Long> destination) {
		try {
			User user = userRepo.findById(userID).orElse(null);
			user.setLocation(destination);
			User updatedUser = userRepo.save(user);
			return updatedUser;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
