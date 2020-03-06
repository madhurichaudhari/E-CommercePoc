package com.hcl.ecommercepoc.services;

import com.hcl.ecommercepoc.entities.CatalogEntity;
import com.hcl.ecommercepoc.responsemodels.InventoryModel;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CatalogService {

    Mono<CatalogEntity> addProduct(CatalogEntity createOrders);

    Mono<CatalogEntity> updateProduct(CatalogEntity createOrders, String id);

    Flux<CatalogEntity> findAll();

    Mono<CatalogEntity> findOne(String id);

    Flux<CatalogEntity> findById(String title);

    Mono<Boolean> delete(String id);
    
    Mono<String> checkInventory();
}
