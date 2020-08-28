package com.chat.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.api.entity.User;
import com.chat.api.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> fetchAllUser(){
		List<User> eventsList = userRepository.findAll();
		return eventsList;
	}
	
	public User fetchUser(String emailId){
		Optional<User> eventOptional = userRepository.findById(emailId);
		return eventOptional.isPresent()? eventOptional.get(): null;
	}
	
	public void createNewUser(User user){
		userRepository.save(user);
	}
	
	

}
