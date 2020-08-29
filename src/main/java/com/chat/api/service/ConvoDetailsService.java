package com.chat.api.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.api.entity.MessageTemplate;
import com.chat.api.repository.ConvoDetailsRepository;

@Service
public class ConvoDetailsService {

	@Autowired
	ConvoDetailsRepository convoDetailsRepository;

	public void insertConvo(MessageTemplate message) {
		convoDetailsRepository.save(message);
	}

	public List<MessageTemplate> getConvoBtwUsers(String convoKey) {
		return convoDetailsRepository.findByConvoKey(convoKey);
	}

	public List<MessageTemplate> getNewConvoBtwUsers(Date date, Date date2) {
		return convoDetailsRepository.findByDateBetween(new Date(), new Date());
	}

}
