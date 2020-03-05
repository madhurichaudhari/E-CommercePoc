package com.hcl.ecommercepoc.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.hcl.ecommercepoc.entities.CatalogEntity;
import com.hcl.ecommercepoc.serviceimp.CatalogServiceImpl;
import com.hcl.ecommercepoc.services.CatalogService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@WebFluxTest
class CatalogControllerTest {

	@Autowired
	private WebTestClient webTestClient;
	@MockBean
	private CatalogServiceImpl userService;

	@Test
	public void addProduct_whenSuccess() {
		CatalogEntity user = new CatalogEntity();
		user.setProductId("1");
		user.setProductDescription("AB");
		Mockito.when(userService.addProduct(Mockito.any(CatalogEntity.class))).thenReturn(Mono.just(user));
		webTestClient.post().uri("/e-commerce/Catalog/addProduct").contentType(MediaType.APPLICATION_JSON)
				.body(Mono.just(user), CatalogEntity.class).exchange().expectStatus().isCreated();

	}
	
	   @Test
	    public void getById() {
		   CatalogEntity user = new CatalogEntity();
			user.setProductId("1");
			user.setProductDescription("AB"); 
	        Mockito.when(userService.findOne(user.getProductId()))
	                .thenReturn(Mono.just(user));

	        webTestClient.get()
	                .uri("/e-commerce/Catalog/fetchProductDetails/"+user.getProductId())
	                .exchange()
	                .expectStatus().isOk();
	    }

	    @Test
	    public void getAll() {
	    	 CatalogEntity user = new CatalogEntity();
				user.setProductId("1");
				user.setProductDescription("AB"); 
				Mockito.when(userService.findAll())
	                .thenReturn(Flux.just(user));

	        webTestClient.get()
	                .uri("/e-commerce/Catalog/fetchAllProduct")
	                .accept(MediaType.APPLICATION_JSON)
	                .exchange()
	                .expectStatus().isOk()
	                .expectBody()
	                .jsonPath("$.[0].productId").isEqualTo("1");
	    }
	

	 @Test
	    public void delete() {
		 CatalogEntity user = new CatalogEntity();
			user.setProductId("1");
			user.setProductDescription("AB");
	        Mockito.when(userService.findById(user.getProductId()))
	                .thenReturn(Flux.just(user));
	        Mockito.when(userService.delete(user.getProductId()))
	                .thenReturn(Mono.empty());

	        webTestClient.delete()
	                .uri("/e-commerce/Catalog/deleteProduct/"+user.getProductId())
	                .exchange()
	                .expectStatus().isOk();
	    }

	    @Test
	    public void update() {
	    	CatalogEntity user = new CatalogEntity();
			user.setProductId("1");
			user.setProductDescription("AB");

	        Mockito.when(userService.findById(user.getProductId()))
	                .thenReturn(Flux.just(user));

	        Mockito.when(userService.updateProduct(user,"1"))
	                .thenReturn(Mono.just(user));

	        webTestClient.put()
	                .uri("/e-commerce/Catalog/updateProduct/"+user.getProductId())
	                .contentType(MediaType.APPLICATION_JSON)
	                .body(Mono.just(user), CatalogEntity.class)
	                .exchange()
	                .expectStatus().isOk();

	    }
	
	
	
	
	
	
	
	
	
	
	
}
