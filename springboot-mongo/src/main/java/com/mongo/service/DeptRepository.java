package com.mongo.service;

import com.mongo.entity.Dept;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: willow
 * @time: 2019/9/13 14:54
 */
@Service
public interface DeptRepository extends MongoRepository<Dept, Integer> {


    public List<Dept> findByName(String name);

}
