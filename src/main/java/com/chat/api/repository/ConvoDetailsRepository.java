package com.chat.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.chat.api.entity.MessageTemplate;


@Repository
public interface ConvoDetailsRepository extends MongoRepository<MessageTemplate, String> {

}