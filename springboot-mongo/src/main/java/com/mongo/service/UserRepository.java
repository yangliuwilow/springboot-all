package com.mongo.service;

import com.mongo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: willow
 * @time: 2019/9/13 14:54
 */
@Service
public interface UserRepository extends MongoRepository<User, String> {


    public List<User> findByName(String name);

}
