package com.hcl.ecommercepoc.services;

import com.hcl.ecommercepoc.entities.ProductCategory;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductCategoryService {

    Mono<ProductCategory> addCategory(ProductCategory createCategory);

    Mono<ProductCategory> updateCategory(ProductCategory createCategory, String id);

    Flux<ProductCategory> findAll();

    Mono<ProductCategory> findOne(String id);

    Flux<ProductCategory> findById(String title);

    Mono<Boolean> delete(String id);
}
