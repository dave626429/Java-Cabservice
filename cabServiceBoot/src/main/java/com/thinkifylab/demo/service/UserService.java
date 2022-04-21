package com.thinkifylab.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.thinkifylab.demo.entity.Driver;
import com.thinkifylab.demo.entity.Location;
import com.thinkifylab.demo.entity.User;

@Service
public interface UserService {
	public User addUser(User user);
	public List<User> addUsers(List<User> users);
	public List<Driver> findRide(Long current_x,Long current_y);
	public Optional<Driver> chooseRide(Long driverId);
	public User updateUserLocation(Long userID,Location<Long,Long> destication);
}
