package com.chat.api.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.chat.api.entity.MessageTemplate;
import com.chat.api.service.ConvoDetailsService;

@RestController
public class ConvoDetailsController {

	@Autowired
	ConvoDetailsService convoDetailsService;

	@GetMapping("/convoBtwUsrs/{convoKey}")
	public List<MessageTemplate> getConvoBtwUsers(@PathVariable String convoKey) {
		return convoDetailsService.getConvoBtwUsers(convoKey);
	}
	
	@GetMapping("/newConvoBtwUsrs/{convoKey}")
	public List<MessageTemplate> getNewConvoBtwUsers(@PathVariable String convoKey) {
		return convoDetailsService.getNewConvoBtwUsers(new Date(), new Date());
	}

}
