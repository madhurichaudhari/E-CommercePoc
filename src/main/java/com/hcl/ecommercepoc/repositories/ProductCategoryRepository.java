package com.hcl.ecommercepoc.repositories;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ecommercepoc.entities.CatalogEntity;
import com.hcl.ecommercepoc.entities.ProductCategoryEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ProductCategoryRepository extends ReactiveMongoRepository<ProductCategoryEntity, String> {

   
}
