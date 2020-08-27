package com.chat.api.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chat.api.entity.User;
import com.chat.api.repository.UserRepository;


@RestController
public class UserController {
	Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/getAllUsers")
	public List<User> getAllEvents() {
		List<User> eventsList = userRepository.findAll();
		return eventsList;
	}

	@GetMapping("/user/{userId}")
	public User getEvent(@PathVariable String userId) {
		Optional<User> eventOptional = userRepository.findById(userId);
		return eventOptional.isPresent()? eventOptional.get(): null;
	}
	
	@PostMapping("/user")
	public void insertUser(@RequestBody User user) {
		userRepository.save(user);
	}

	
}
