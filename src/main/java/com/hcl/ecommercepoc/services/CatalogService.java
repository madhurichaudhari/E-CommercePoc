package com.hcl.ecommercepoc.services;

import java.util.List;

import com.hcl.ecommercepoc.entities.Catalog;
import com.hcl.ecommercepoc.responsemodels.ApiResponseModel;
import com.hcl.ecommercepoc.responsemodels.inventory.InventoryDetails;
import com.hcl.ecommercepoc.responsemodels.inventory.InventoryModel;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CatalogService {

    Mono<Catalog> addProduct(Catalog createOrders);

    Mono<Catalog> updateProduct(Catalog createOrders, String id);

    Flux<Catalog> findAllProduct();

    Mono<Catalog> findProductById(String id);

   

    Mono<Boolean> delete(String id);
    
    Integer checkInventory();
    
   List<InventoryDetails> checkAllInventoryQuantity();
}
