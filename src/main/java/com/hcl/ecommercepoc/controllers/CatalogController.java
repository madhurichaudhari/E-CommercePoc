package com.hcl.ecommercepoc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.hcl.ecommercepoc.entities.CatalogEntity;
import com.hcl.ecommercepoc.services.CatalogService;
import org.springframework.http.HttpStatus;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author MadhuriC Created CatalogController through manage Catalog .
 */
@RestController
@RequestMapping("e-commerce/Catalog")
public class CatalogController {

	@Autowired
	private CatalogService productService;
	@Autowired
	com.hcl.ecommercepoc.utils.Configuration configuration;

	/**
	 *  This api is used for add  product  of catalog
	 * @param CatalogEntity
	 * @return Mono<CatalogEntity>
	 */
	@PostMapping("/addProduct")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<CatalogEntity> addProduct(@RequestBody CatalogEntity catalogEntity) {
		return productService.addProduct(catalogEntity);
	}
	
	/**
	 * This api is used for update  product  of catalog
	 * @return  data
	 */

	@PutMapping("/updateProduct/{productId}")
	@ResponseStatus(HttpStatus.OK)
	public Mono<CatalogEntity> updateProduct(@RequestBody CatalogEntity catalogEntity, @PathVariable String productId) {
		return productService.updateProduct(catalogEntity, productId);
	}

	
	/**
	 * This api is used for fetch all  product  of catalog
	 * @return  data
	 */
	
	@GetMapping("/fetchAllProduct")
	@ResponseStatus(HttpStatus.OK)
	public Flux<CatalogEntity> findAll() {
		return productService.findAll();
	}

	/**
	 * This api is used for fetch  product detail of catalog
	 * @return  data
	 */
	
	@GetMapping("/fetchProductDetails/{productId}")
	@ResponseStatus(HttpStatus.OK)
	public Mono<CatalogEntity> findOne(@PathVariable String productId) {
		return productService.findOne(productId);
	}
	
	/**
	 * This api is used for delete product of catalog
	 * @return  data
	 */

	@DeleteMapping("/deleteProduct/{productId}")
	@ResponseStatus(HttpStatus.OK)
	public Mono<Boolean> delete(@PathVariable String productId) {
		return productService.delete(productId);
	}
	
	/**
	 * This api is used for checking connection data from APi Gateway
	 * @return  data
	 */

	@GetMapping("/getConfig")
	public String demo() {
		return "madhuri" + configuration.getMaximum();
	}

	/**
	 * This api is used for checking connection data from APi Gateway
	 * @return  data
	 */
	@GetMapping("/getTest")
	public String demoTest() {
		return "200";
	}

	/**
	 * This api is used for getting data from APi Gateway
	 * @return it will return data for Jull Api
	 */
	@GetMapping("/getZuulTest")
	public String getProducerTest() {
		String baseUrl = "http://10.110.244.179:8011/producer/jullTest";
		System.out.println("baseUrl>>>>>>" + baseUrl);
		RestTemplate restTemplate = new RestTemplate();
		String data = restTemplate.getForObject(baseUrl, String.class);
		System.out.println("dataDemo>>>>>>" + data);
		return data;

	}

}
