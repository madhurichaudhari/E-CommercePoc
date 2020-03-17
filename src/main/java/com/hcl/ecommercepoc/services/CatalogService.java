package com.hcl.ecommercepoc.services;

import java.util.List;

import com.hcl.ecommercepoc.entities.CatalogEntity;
import com.hcl.ecommercepoc.responsemodels.ApiResponseModel;
import com.hcl.ecommercepoc.responsemodels.inventory.InventoryDetails;
import com.hcl.ecommercepoc.responsemodels.inventory.InventoryModel;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CatalogService {

	/**
	 * @param catalogEntity
	 * @return CatalogEntity
	 */
	Mono<CatalogEntity> addProduct(CatalogEntity catalogEntity);

	/**
	 * @param createOrders
	 * @param id
	 * @return CatalogEntity
	 */
	Mono<CatalogEntity> updateProduct(CatalogEntity createOrders, String id);

	/**
	 * @return CatalogEntity
	 */
	Flux<CatalogEntity> findAllProduct();

	/**
	 * @param id
	 * @return CatalogEntity
	 */
	Mono<CatalogEntity> findProductById(String id);

	/**
	 * @param id
	 * @return CatalogEntity
	 */
	Mono<CatalogEntity> delete(String id);

	/**
	 * @return CatalogEntity
	 */
	InventoryModel checkInventory();

	List<InventoryDetails> checkAllInventoryQuantity();

	/**
	 * @return CatalogEntity
	 */
	CatalogEntity getProductData();
}
