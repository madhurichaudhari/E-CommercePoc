package com.hcl.ecommercepoc.controllers;

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
	private CatalogService catalogService;

	@Test
	public void addProduct_whenTestSuccess() {
		CatalogEntity catalogEntity = new CatalogEntity();
		catalogEntity.setProductId("1");
		catalogEntity.setProductDescription("AB");
		Mockito.when(catalogService.addProduct(Mockito.any(CatalogEntity.class))).thenReturn(Mono.just(catalogEntity));
		webTestClient.post().uri("/e-commerce/catalog/addProduct").contentType(MediaType.APPLICATION_JSON)
				.body(Mono.just(catalogEntity), CatalogEntity.class).exchange().expectStatus().isCreated();

	}

	@Test
	public void addProduct_whenTestFail() {
		CatalogEntity catalogEntity = new CatalogEntity();
		catalogEntity.setProductId("1");
		catalogEntity.setProductDescription("AB");
		Mockito.when(catalogService.addProduct(Mockito.any(CatalogEntity.class))).thenReturn((null));
		webTestClient.post().uri("/e-commerce/catalog/addProduct").contentType(MediaType.APPLICATION_JSON)
				.body(Mono.just(catalogEntity), CatalogEntity.class).exchange().expectStatus().is5xxServerError();

	}

	@Test
	public void getById() {
		CatalogEntity user = new CatalogEntity();
		user.setProductId("1");
		user.setProductDescription("AB");
		Mockito.when(catalogService.findOne(user.getProductId())).thenReturn(Mono.just(user));

		webTestClient.get().uri("/e-commerce/catalog/fetchProductDetails/" + user.getProductId()).exchange()
				.expectStatus().isOk();
	}

	@Test
	public void getAll() {
		CatalogEntity user = new CatalogEntity();
		user.setProductId("1");
		user.setProductDescription("AB");
		Mockito.when(catalogService.findAll()).thenReturn(Flux.just(user));

		webTestClient.get().uri("/e-commerce/catalog/fetchAllProduct").accept(MediaType.APPLICATION_JSON).exchange()
				.expectStatus().isOk().expectBody().jsonPath("$.[0].productId").isEqualTo("1");
	}

	@Test
	public void delete() {
		CatalogEntity user = new CatalogEntity();
		user.setProductId("1");
		user.setProductDescription("AB");
		Mockito.when(catalogService.findById(user.getProductId())).thenReturn(Flux.just(user));
		Mockito.when(catalogService.delete(user.getProductId())).thenReturn(Mono.empty());

		webTestClient.delete().uri("/e-commerce/catalog/deleteProduct/" + user.getProductId()).exchange().expectStatus()
				.isOk();
	}

	@Test
	public void update() {
		CatalogEntity user = new CatalogEntity();
		user.setProductId("1");
		user.setProductDescription("AB");

		Mockito.when(catalogService.findById(user.getProductId())).thenReturn(Flux.just(user));

		Mockito.when(catalogService.updateProduct(user, "1")).thenReturn(Mono.just(user));

		webTestClient.put().uri("/e-commerce/catalog/updateProduct/" + user.getProductId())
				.contentType(MediaType.APPLICATION_JSON).body(Mono.just(user), CatalogEntity.class).exchange()
				.expectStatus().isOk();

	}

	@Test
	public void addProduct_whenSuccessTest() {
		CatalogEntity catalogEntity = new CatalogEntity();
		catalogEntity.setProductId("1");
		catalogEntity.setProductDescription("AB");
		Mockito.when(catalogService.addProduct(Mockito.any(CatalogEntity.class))).thenReturn(Mono.just(catalogEntity));
		webTestClient.post().uri("/e-commerce/catalog/bizagi/sendmsg").contentType(MediaType.APPLICATION_JSON)
				.body(Mono.just(catalogEntity), CatalogEntity.class).exchange().expectStatus().isCreated();

	}

}
