package com.chat.api.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.chat.api.entity.MessageTemplate;


@Repository
public interface ConvoDetailsRepository extends MongoRepository<MessageTemplate, String> {
	List<MessageTemplate> findByConvoKey(String convoKey);
	List<MessageTemplate> findByDateBetween(Date startDate, Date endDate);
}