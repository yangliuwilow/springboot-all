package com.wilow.elasticsearch.service;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PersonRepository extends ElasticsearchRepository<Person, Integer> {




}
