package com.hcl.ecommercepoc.repositories;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ecommercepoc.entities.Catalog;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CatalogRepository extends ReactiveMongoRepository<Catalog, String> {

   // Flux<ProductOrders> findByOrderId(String author);

  //  Flux<ProductOrders> findByAuthorAndDeleteIsFalse(String titleKeyword);

    //Mono<ProductOrders> findByOrderId(String title);

  //  Mono<ProductOrders> findByOrderIdAndDeleteIsFalse(String id);
}
