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
import com.thinkifylab.demo.entity.User;
import com.thinkifylab.demo.repository.UserRepository;
import com.thinkifylab.demo.service.UserService;

@RestController
@RequestMapping(path = "/apis_v1/users")
public class UserController {

	@Autowired
	UserService userSerive;

	// Testing Scope begin
	@Autowired
	UserRepository userRepo;

	@GetMapping(path = "/")
	public List<User> getUsers() {
		List<User> response = userRepo.findAll();
		System.out.println(response);
		return response;
	}

	@GetMapping(path = "/{id}")
	public Optional<User> getUser(@PathVariable Long id) {
		Optional<User> response = userRepo.findById(id);
		System.out.println(response);
		return response;
	}
	// Testing Scope end

	@GetMapping(path = "/rides")
	public List<Driver> findRides(@RequestParam Long x, @RequestParam Long y) {
		return userSerive.findRide(x, y);
	}

	@GetMapping(path = "/rides/{id}")
	public Optional<Driver> chooseRides(@PathVariable Long id) {
		return userSerive.chooseRide(id);
	}

	@PutMapping(path = "/updateuser/location/{id}")
	public User updateUserLocation(@PathVariable(name = "id") Long userId, @RequestBody Location<Long, Long> destinationLocation) {
		return userSerive.updateUserLocation(userId, destinationLocation);
	}

	@PostMapping(path = "/adduser")
	public User addUser(@RequestBody User user) {
		return userSerive.addUser(user);
	}

	@PostMapping(path = "/addusers")
	public List<User> addUsers(@RequestBody List<User> user) {
		return userSerive.addUsers(user);
	}

}
