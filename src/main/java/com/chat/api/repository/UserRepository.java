package com.chat.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.chat.api.entity.User;


@Repository
public interface UserRepository extends MongoRepository<User, String> {

}