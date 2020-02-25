package com.hcl.ecommercepoc.services;

import com.hcl.ecommercepoc.entities.ProductOrders;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderService {

    Mono<ProductOrders> createOrder(ProductOrders createOrders);

    Mono<ProductOrders> updateOrder(ProductOrders createOrders, String id);

    Flux<ProductOrders> findAll();

    Mono<ProductOrders> findOne(String id);

    Flux<ProductOrders> findById(String title);

    Mono<Boolean> delete(String id);
}
