package com.hcl.ecommercepoc.services;

import com.hcl.ecommercepoc.entities.ProductCategoryEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductCategoryService {

    Mono<ProductCategoryEntity> addCategory(ProductCategoryEntity createCategory);

    Mono<ProductCategoryEntity> updateCategory(ProductCategoryEntity createCategory, String id);

    Flux<ProductCategoryEntity> findAll();

    Mono<ProductCategoryEntity> findOne(String id);

    Flux<ProductCategoryEntity> findById(String title);

    Mono<Boolean> delete(String id);
}
