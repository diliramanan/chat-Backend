package com.chat.api.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.api.entity.MessageTemplate;
import com.chat.api.entity.UnSeenMsg;
import com.chat.api.repository.ConvoDetailsRepository;

@Service
public class ConvoDetailsService {

	@Autowired
	ConvoDetailsRepository convoDetailsRepository;

	public void insertConvo(MessageTemplate message) {
		convoDetailsRepository.save(message);
	}

	public List<MessageTemplate> getConvoBtwUsers(String convoKey, String toUser) {
		List<MessageTemplate> lst = convoDetailsRepository.findByConvoKey(convoKey);
		for (MessageTemplate messageTemplate : lst) { 
			if(messageTemplate.getToUser().equals(toUser)) {
				messageTemplate.setLastSeen(true); 
			}
			System.out.println("UPDATE messageTemplate:"+messageTemplate);
			convoDetailsRepository.save(messageTemplate);
		}
		return lst;
	}

	public List<MessageTemplate> getNewConvoBtwUsers(Date date, Date date2) {
		return convoDetailsRepository.findByDateBetween(new Date(), new Date());
	}

	public List<UnSeenMsg> findByToUserAndLastSeen(String user, boolean b) {
		List<MessageTemplate> unSeenConvoList = convoDetailsRepository.findByToUserAndLastSeen(user, false);
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		String fromUser = null;
		for (MessageTemplate messageTemplate : unSeenConvoList) {
			if(fromUser==null) {
				fromUser = messageTemplate.getUser();
				map.put(fromUser, 1);
			}else {
				map.put(fromUser, map.get(fromUser)+1);
			}
		}
		List<UnSeenMsg> unSeenMsgCountList = new ArrayList<>();
		for (Entry<String, Integer> entry : map.entrySet()) {
			UnSeenMsg unSeenMsg = new UnSeenMsg();
			unSeenMsg.setFromUser(entry.getKey());
			unSeenMsg.setCount(entry.getValue());
			unSeenMsgCountList.add(unSeenMsg);
		}
		System.out.println("unSeenMsgCountList="+unSeenMsgCountList);
		return unSeenMsgCountList;
	}

}
