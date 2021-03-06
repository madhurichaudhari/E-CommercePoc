package com.hcl.ecommercepoc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hcl.ecommercepoc.entities.Catalog;
import com.hcl.ecommercepoc.responsemodels.ApiResponseModel;
import com.hcl.ecommercepoc.services.CatalogService;
import com.hcl.ecommercepoc.utils.AppConstant;
import com.hcl.ecommercepoc.utils.CommonUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author MadhuriC Created CatalogController through manage Catalog .
 */

@RestController
@RequestMapping(value = "e-commerce/catalog", produces = MediaType.APPLICATION_JSON_VALUE)
public class CatalogController {

	@Autowired(required = true)
	private CatalogService catalogService;

	/*
	 * @Autowired com.hcl.ecommercepoc.utils.Configuration configuration;
	 */

	/**
	 * This api is used for add product of catalog
	 * @param Catalog
	 * @return Mono<CatalogEntity>
	 */
	@PostMapping("/addProduct")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<ResponseEntity<?>> addProduct(@RequestBody Catalog catalogEntity) {
		Mono<Catalog> catalogData = catalogService.addProduct(catalogEntity);
		return catalogData.map(t -> {
			return new ResponseEntity<Object>(new ApiResponseModel(true, AppConstant.PRODUCT_ADDED, t, 200),
					HttpStatus.CREATED);

		});
	}

	/**
	 * This api is used for update product of catalog
	 * 
	 * @return data
	 */

	@PutMapping("/updateProduct/{productId}")
	public Mono<ResponseEntity<?>> updateProduct(@RequestBody Catalog catalogEntity,
			@PathVariable String productId) {
		// return catalogService.updateProduct(catalogEntity, productId);
		Mono<Catalog> catalogData = catalogService.updateProduct(catalogEntity, productId);
		return catalogData.map(t -> {
			return new ResponseEntity<Object>(new ApiResponseModel(true, AppConstant.PRODUCT_UPDATED, t, 200),
					HttpStatus.OK);

		});

	}

	/**
	 * This api is used for fetch all product of catalog
	 * 
	 * @return data
	 */

	@GetMapping("/fetchAllProduct")
	public Flux<Catalog> findAll() {
		// return catalogService.findAll();

		Flux<Catalog> catalogData = catalogService.findAllProduct();
		return catalogData;
		
	}

	/**
	 * This api is used for fetch product detail of catalog
	 * 
	 * @return data
	 */

	@GetMapping("/fetchProductDetails/{productId}")
	public Mono<ResponseEntity<?>> findOne(@PathVariable String productId) {
		// return catalogService.findOne(productId);

		Mono<Catalog> catalogData = catalogService.findProductById(productId);
		return catalogData.map(t -> {
			return new ResponseEntity<Object>(new ApiResponseModel(true, AppConstant.PRODUCT_FETCH_DETAILS, t, 200),
					HttpStatus.OK);

		});

	}

	/**
	 * This api is used for delete product of catalog
	 * 
	 * @return data
	 */

	@DeleteMapping("/deleteProduct/{productId}")
	@ResponseStatus(HttpStatus.OK)
	public Mono<ResponseEntity<?>> delete(@PathVariable String productId) {
		// return catalogService.delete(productId);
		Mono<Catalog> catalogData = catalogService.delete(productId);
		
		return catalogData.map(t -> {
			return new ResponseEntity<Object>(new ApiResponseModel(true, AppConstant.PRODUCT_DELETED, t, 200),
					HttpStatus.OK);

		});
		}

	/**
	 * This api is used for checking connection data from APi Gateway
	 * 
	 * @return data
	 */
	@GetMapping("/getTest")
	public String demoTest() {
		return "200";
	}

	@GetMapping("/getQauntity")
	public Integer getQuntity() {
		return catalogService.checkAllInventoryQuantity().get(2).getQuantity();
	}

	/**
	 * @param token
	 * @param bizagiPost
	 * @return
	 */
	@PostMapping(value = "/bizagi/sendmsg")
	public ResponseEntity<Mono<?>> sendMessageToQueue(@RequestHeader("Authorization") String token,
			@RequestBody Catalog bizagiPost) {
         System.out.println("token::" + token);
		boolean tokenStatus = CommonUtil.validateToken(token);

		if (tokenStatus) {
			Mono<Catalog> catalogData = catalogService.addProduct(bizagiPost);
			   return new ResponseEntity<>(Mono.just(new ApiResponseModel(true, AppConstant.PRODUCT_DELETED, catalogData, 200)), HttpStatus.OK);

	
		}
		else {
				  
			  // return new ResponseEntity<>(Mono.just(new Life()), HttpStatus.I_AM_A_TEAPOT);
			   return new ResponseEntity<>(Mono.just(new ApiResponseModel(true, AppConstant.PRODUCT_DELETED, null, 500)), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	

	}

	/**
	 * This api is used for getting data from APi Gateway
	 * 
	 * @return it will return data for Jull Api
	 */
	
	 
	  
	@GetMapping("/getZuul2Test")
	public String demoZuulTest() {
		String baseUrl = "http://10.110.244.179:8011/role-based-oauth-user-service/users/hello-again";
		System.out.println("baseUrl>>>>>>" + baseUrl);
		RestTemplate restTemplate = new RestTemplate();
		String data = restTemplate.getForObject(baseUrl, String.class);
		System.out.println("dataDemo>>>>>>" + data);
		return data;
	}
	 

}
