package com.chat.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.chat.api.entity.MessageTemplate;
import com.chat.api.repository.ConvoDetailsRepository;

@Controller
public class WebSocketController {

    private final SimpMessagingTemplate template;
    
    @Autowired
    ConvoDetailsRepository convoDetailsRepository;

    @Autowired
    WebSocketController(SimpMessagingTemplate template){
        this.template = template;
    }

    @MessageMapping("/send/message")
    public void sendMessage(MessageTemplate message){ 
        System.out.println(message);
        convoDetailsRepository.save(message);
        this.template.convertAndSend("/message",  message);
    }
}