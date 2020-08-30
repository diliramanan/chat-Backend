package com.chat.api.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chat.api.entity.MessageTemplate;
import com.chat.api.entity.UnSeenMsg;
import com.chat.api.service.ConvoDetailsService;

@RestController
public class ConvoDetailsController {

	@Autowired
	private ConvoDetailsService convoDetailsService;

	@GetMapping("/convoBtwUsrs/{convoKey}/{user}")
	public List<MessageTemplate> getConvoBtwUsers(@PathVariable String convoKey, @PathVariable String user) {
		return convoDetailsService.getConvoBtwUsers(convoKey,user);
	}

	@GetMapping("/newConvoBtwUsrs/{convoKey}")
	public List<MessageTemplate> getNewConvoBtwUsers(@PathVariable String convoKey) {
		return convoDetailsService.getNewConvoBtwUsers(new Date(), new Date());
	}

	@GetMapping("/getUnseenConvo/{user}/{convoKey}")
	public  List<UnSeenMsg> getUnseenConvo(@PathVariable String user, @PathVariable String convoKey) {
		return convoDetailsService.findByToUserAndLastSeen(user, false);
	}

	@PutMapping("/updateUnseenConvo/{convoKey}/{user}")
	public void updateUnseen(@PathVariable String convoKey, @PathVariable String user) {
		convoDetailsService.updateUnseen(convoKey,user,false);
	}

}
