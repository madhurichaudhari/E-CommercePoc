package com.hcl.ecommercepoc.services;

import java.util.List;

import com.hcl.ecommercepoc.entities.Catalog;
import com.hcl.ecommercepoc.responsemodels.inventory.InventoryDetails;
import com.hcl.ecommercepoc.responsemodels.inventory.InventoryModel;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CatalogService {

	/**
	 * @param Catalog
	 * @return Catalog
	 */
	Mono<Catalog> addProduct(Catalog catalog);

	/**
	 * @param createOrders
	 * @param id
	 * @return CatalogEntity
	 */
	Mono<Catalog> updateProduct(Catalog catalog, String id);

	/**
	 * @return Catalog
	 */
	Flux<Catalog> findAllProduct();

	/**
	 * @param id
	 * @return Catalog
	 */
	Mono<Catalog> findProductById(String id);

	/**
	 * @param id
	 * @return Catalog
	 */
	Mono<Catalog> delete(String id);

	/**
	 * @return Catalog
	 */
	InventoryModel checkInventory();

	/**
	 * @return InventoryDetails
	 */
	List<InventoryDetails> checkAllInventoryQuantity();

	/**
	 * @return Catalog
	 */
	Catalog getProductData();
}