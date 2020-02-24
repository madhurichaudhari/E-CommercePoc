package com.hcl.ecommercepoc.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hcl.ecommercepoc.entities.UserEntities;

public interface UserRepository extends MongoRepository<UserEntities, String> {

	UserEntities findByUsername(String username);

}
