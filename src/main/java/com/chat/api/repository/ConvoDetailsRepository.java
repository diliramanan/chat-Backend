package com.chat.api.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.chat.api.entity.MessageTemplate;


@Repository
public interface ConvoDetailsRepository extends MongoRepository<MessageTemplate, String> {
	List<MessageTemplate> findByConvoKey(String convoKey);
	List<MessageTemplate> findByDateBetween(Date startDate, Date endDate);
	List<MessageTemplate> findByToUserAndLastSeen(String toUser, boolean lastSeen);
//	List<MessageTemplate> findByConvoKeyAndToUserAndLastSeen(String convoKey, String toUser, boolean lastseen);
	
	@Query(value = "{convoKey : ?0, toUser : ?1, lastSeen : ?2 }")
	List<MessageTemplate> findUnseen(String convoKey, String toUser, boolean lastseen);
}