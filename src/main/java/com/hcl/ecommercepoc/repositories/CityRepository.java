package com.hcl.ecommercepoc.repositories;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.hcl.ecommercepoc.entities.City;

@Configuration
public interface CityRepository extends ReactiveMongoRepository<City, String> {
}