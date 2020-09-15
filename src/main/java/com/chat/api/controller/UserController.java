package com.chat.api.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chat.api.entity.User;
import com.chat.api.service.UserService;


@RestController
@CrossOrigin(origins = "/**")
public class UserController {
	
	Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String welcome() {
		return "Weclome to Chat API";
	}

	@GetMapping("/getAllUsers")
	public List<User> getAllEvents() {
		return userService.fetchAllUser();
	}

	@GetMapping("/user/{emailId}")
	public User getEvent(@PathVariable String emailId) {
		return userService.fetchUser(emailId);
	}
	
	@PostMapping("/user")
	public void insertUser(@RequestBody User user) {
		userService.createNewUser(user);
	}

	
}
