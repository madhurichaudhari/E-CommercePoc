package com.hcl.ecommercepoc.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import com.hcl.ecommercepoc.entities.CatalogEntity;
import com.hcl.ecommercepoc.services.CatalogService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@WebFluxTest
class CatalogControllerTest {

	@Autowired
	private WebTestClient webTestClient;

	@MockBean
	private CatalogService catalogService;

	@Test
	public void testAddProduct_whenSuccess() {
		CatalogEntity catalogEntity = new CatalogEntity();
		catalogEntity.setProductId("1");
		catalogEntity.setProductDescription("AB");
		Mockito.when(catalogService.addProduct(Mockito.any(CatalogEntity.class))).thenReturn(Mono.just(catalogEntity));
		webTestClient.post().uri("/e-commerce/catalog/addProduct").contentType(MediaType.APPLICATION_JSON)
				.body(Mono.just(catalogEntity), CatalogEntity.class).exchange().expectStatus().isCreated();

	}

	@Test
	public void testaddProduct_whenFail() {
		CatalogEntity catalogEntity = new CatalogEntity();
		catalogEntity.setProductId("1");
		catalogEntity.setProductDescription("AB");
		Mockito.when(catalogService.addProduct(Mockito.any(CatalogEntity.class))).thenReturn((null));
		webTestClient.post().uri("/e-commerce/catalog/addProduct").contentType(MediaType.APPLICATION_JSON)
				.body(Mono.just(catalogEntity), CatalogEntity.class).exchange().expectStatus().is5xxServerError();

	}

	@Test
	public void testFetchProduct_whenSuccess() {
		CatalogEntity catalogEntity = new CatalogEntity();
		catalogEntity.setProductId("1");
		catalogEntity.setProductDescription("AB");
		Mockito.when(catalogService.findProductById(catalogEntity.getProductId())).thenReturn(Mono.just(catalogEntity));

		webTestClient.get().uri("/e-commerce/catalog/fetchProductDetails/" + catalogEntity.getProductId()).exchange()
				.expectStatus().isOk();
	}
	//fetch
	@Test
	public void testFetchProduct_whenFail() {
		CatalogEntity catalogEntity = new CatalogEntity();
		catalogEntity.setProductId("1");
		catalogEntity.setProductDescription("AB");
		Mockito.when(catalogService.findProductById(catalogEntity.getProductId())).thenReturn(null);

		webTestClient.get().uri("/e-commerce/catalog/fetchProductDetails/" + catalogEntity.getProductId()).exchange()
				.expectStatus().is5xxServerError();
	}
	

	@Test
	public void testFetchAllProduct_whenSuccess() {
		CatalogEntity catalogEntity = new CatalogEntity();
		catalogEntity.setProductId("1");
		catalogEntity.setProductDescription("AB");
		Mockito.when(catalogService.findAllProduct()).thenReturn(Flux.just(catalogEntity));
		webTestClient.get().uri("/e-commerce/catalog/fetchAllProduct/").accept(MediaType.APPLICATION_JSON).exchange()
				.expectStatus().isOk().expectBody().jsonPath("$.[0].productId").isEqualTo("1");
	}
	@Test
	public void testFetchAllProduct_whenFail() {
		Mockito.when(catalogService.findAllProduct()).thenReturn(null);
		webTestClient.get().uri("/e-commerce/catalog/fetchAllProduct").accept(MediaType.APPLICATION_JSON).exchange()
		.expectStatus().isOk().expectBody().equals("[]");
	}

	@Test
	public void testDeleteProduct_whenSuccess() {
		CatalogEntity catalogEntity = new CatalogEntity();
		catalogEntity.setProductId("1");
		catalogEntity.setProductDescription("AB");
		Mockito.when(catalogService.findProductById(catalogEntity.getProductId())).thenReturn(Mono.just(catalogEntity));
		Mockito.when(catalogService.delete(catalogEntity.getProductId())).thenReturn(Mono.empty());

		webTestClient.delete().uri("/e-commerce/catalog/deleteProduct/" + catalogEntity.getProductId()).exchange().expectStatus()
				.isOk();
	}
	//fail
	@Test
	public void testDeleteProduct_whenFail() {
		CatalogEntity catalogEntity = new CatalogEntity();
		catalogEntity.setProductId("1");
		catalogEntity.setProductDescription("AB");
		Mockito.when(catalogService.findProductById(catalogEntity.getProductId())).thenReturn(null);
		Mockito.when(catalogService.delete("2")).thenReturn(Mono.empty());
		
		webTestClient.delete().uri("/e-commerce/catalog/deleteProduct/" + catalogEntity.getProductId()).exchange().expectStatus()
		.is5xxServerError();
	}

	@Test
	public void testUpdateProduct_whenSuccess() {
		
		CatalogEntity catalogEntity = new CatalogEntity();
		catalogEntity.setProductId("1");
		catalogEntity.setProductDescription("AB");

		Mockito.when(catalogService.findProductById(catalogEntity.getProductId())).thenReturn(Mono.just(catalogEntity));

		Mockito.when(catalogService.updateProduct(catalogEntity,catalogEntity.getProductId())).thenReturn(Mono.just(catalogEntity));

		webTestClient.put().uri("/e-commerce/catalog/updateProduct/" + catalogEntity.getProductId())
				.contentType(MediaType.APPLICATION_JSON).body(Mono.just(catalogEntity), CatalogEntity.class).exchange()
				.expectStatus().is5xxServerError();

	}
	@Test
	public void testUpdateProduct_whenFail() {
		CatalogEntity catalogEntity = new CatalogEntity();
		catalogEntity.setProductId("1");
		catalogEntity.setProductDescription("AB");
		
		Mockito.when(catalogService.findProductById(catalogEntity.getProductId())).thenReturn(Mono.just(catalogEntity));
		
		Mockito.when(catalogService.updateProduct(catalogEntity, "1")).thenReturn(Mono.just(catalogEntity));
		
		webTestClient.put().uri("/e-commerce/catalog/updateProduct/" + catalogEntity.getProductId())
		.contentType(MediaType.APPLICATION_JSON).body(Mono.just(catalogEntity), CatalogEntity.class).exchange()
		.expectStatus().is5xxServerError();
		
	}

	

}
