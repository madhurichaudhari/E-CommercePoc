package com.hcl.ecommercepoc.repositories;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ecommercepoc.entities.Catalog;
import com.hcl.ecommercepoc.entities.ProductCategory;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ProductCategoryRepository extends ReactiveMongoRepository<ProductCategory, String> {

   
}
