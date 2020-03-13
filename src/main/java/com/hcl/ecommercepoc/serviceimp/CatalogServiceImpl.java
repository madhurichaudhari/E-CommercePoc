package com.hcl.ecommercepoc.serviceimp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.hcl.ecommercepoc.entities.CatalogEntity;
import com.hcl.ecommercepoc.repositories.CatalogRepository;
import com.hcl.ecommercepoc.responsemodels.inventory.AllInventoryModel;
import com.hcl.ecommercepoc.responsemodels.inventory.InventoryDetails;
import com.hcl.ecommercepoc.responsemodels.inventory.InventoryModel;
import com.hcl.ecommercepoc.services.CatalogService;
import com.hcl.ecommercepoc.utils.AppConstant;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CatalogServiceImpl implements CatalogService {

	@Autowired
	private CatalogRepository catalogRepository;

	@Override
	public Mono<CatalogEntity> addProduct(CatalogEntity catalogEntity) {
		 Mono<CatalogEntity> fallback = Mono.error(new Exception(AppConstant.CHECK_PRODUCT_QUANTITY + catalogEntity));
		return catalogRepository.save(catalogEntity).switchIfEmpty(fallback);
	}

	@Override
	public Flux<CatalogEntity> findAll() {
		List<InventoryDetails> inventoryList = checkAllInventoryQuantity();
		Flux<CatalogEntity> catalogList = null;
		for (int i = 0; i < inventoryList.size(); i++) {
			final int count = 0 + i;
			Integer qunatity = inventoryList.get(i).getQuantity();
			 catalogList = catalogRepository.findAll();
			 
			catalogList.map(it -> inventoryList.get(count).getQuantity());
			
			System.out.println("count:::" + count);
			System.out.println("catalogList:::" + catalogList.collectList());
		}

		catalogRepository.saveAll(catalogList);
		return catalogList;
		//return catalogRepository.findAll();
	}

	@Override
	public Mono<CatalogEntity> updateProduct(CatalogEntity productOrders, String id) {
		 Mono<CatalogEntity> fallback = Mono.error(new Exception(AppConstant.CHECK_PRODUCT_QUANTITY + id));

		return findOne(id).doOnSuccess(productOrders1 -> {
			catalogRepository.save(productOrders);
		});
	}

	@Override
	public Mono<CatalogEntity> findOne(String id) {
		int quantity = checkInventory();
		System.out.println("quantity::" + quantity);

		if (quantity > 0) {
			return catalogRepository.findById(id)
					.switchIfEmpty(Mono.error(new Exception(AppConstant.CHECK_PRODUCT_QUANTITY + id)));
		} else {

			return catalogRepository.findById(id)
					.switchIfEmpty(Mono.error(new Exception(AppConstant.CHECK_PRODUCT_QUANTITY + id)));
		}
	}

	@Override
	public Flux<CatalogEntity> findById(String Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Boolean> delete(String id) {
		 Mono<Boolean> fallback = Mono.error(new Exception(AppConstant.CHECK_PRODUCT_QUANTITY + id));
		return findOne(id).doOnSuccess(blog -> {
			// blog.setDelete(true);
			catalogRepository.deleteById(id).subscribe();
		}).flatMap(blog -> Mono.just(Boolean.TRUE)).switchIfEmpty(fallback);
	}

	@Override
	public Integer checkInventory() {

		/*
		 * InventoryModel inventoryModel = new RestTemplate()
		 * .getForObject("http://10.110.244.83:7001/inventory/Item/109",
		 * InventoryModel.class);
		 * 
		 * System.out.println("inventoryModel"+inventoryModel);
		 */

		String json = "{\"data\":{\"id\":17,\"productID\":\"202\",\"quantity\":2},\"message\":\"success\",\"status\":true,\"statusCode\":200}\r\n"
				+ "";

		InventoryModel inventoryResponse = new Gson().fromJson(json, InventoryModel.class);

		System.out.println("inventoryModel" + inventoryResponse);
		return inventoryResponse.getQuantityModel().getQuantity();

		// return inventoryModel.getQuantityModel().getQuantity();
	}

	@Override
	public List<InventoryDetails> checkAllInventoryQuantity() {

		/*
		 * AllInventoryModel inventoryModel = new RestTemplate()
		 * .getForObject("http://10.110.244.83:7001/inventory/",
		 * AllInventoryModel.class);
		 */

		List<Integer> allInventoryList = new ArrayList<Integer>();
		List<InventoryDetails> allInventoryDetailsList = new ArrayList<InventoryDetails>();

		String json = "  {\r\n" + "    \"dataArray\": [\r\n" + "        {\r\n" + "            \"id\": 1,\r\n"
				+ "            \"productID\": \"102\",\r\n" + "            \"quantity\": 2\r\n" + "        },\r\n"
				+ "        {\r\n" + "            \"id\": 2,\r\n" + "            \"productID\": \"102\",\r\n"
				+ "            \"quantity\": 2\r\n" + "        },\r\n" + "        {\r\n" + "            \"id\": 3,\r\n"
				+ "            \"productID\": \"102\",\r\n" + "            \"quantity\": 2\r\n" + "        }\r\n"
				+ "  \r\n" + "    ],\r\n" + "    \"message\": \"Success\",\r\n" + "    \"status\": true,\r\n"
				+ "    \"statusCode\": 200\r\n" + "}\r\n" + "";

		Flux<CatalogEntity> allProductList = catalogRepository.findAll();

		AllInventoryModel inventoryResponse = new Gson().fromJson(json, AllInventoryModel.class);

		System.out.println("inventoryModelList" + inventoryResponse.getDataArray());
		System.out.println("inventoryModel" + inventoryResponse.getDataArray().get(0).getQuantity());

		return inventoryResponse.getDataArray();

	}

}
