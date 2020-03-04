package com.hcl.testecommercepoc.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.hcl.ecommercepoc.controllers.CatalogController;
import com.hcl.ecommercepoc.entities.CatalogEntity;
import com.hcl.ecommercepoc.repositories.CatalogRepository;
import com.hcl.ecommercepoc.services.CatalogService;


@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = CatalogController.class)
@Import(CatalogService.class)
class ECommercePocApplicationTests {
	
	
	
	@MockBean
	CatalogRepository catalogRepository;
 
    @Autowired
    private WebTestClient webClient;
 
    @Test
    void testCreateEmployee() {
    	CatalogEntity catalogEntity = new CatalogEntity();
    	catalogEntity.setProductId("1");
    	catalogEntity.setProductName("Test");
 
		/*
		 * Mockito.when(catalogRepository.save(catalogEntity)).thenReturn(Mono.just(
		 * catalogEntity));
		 * 
		 * webClient.post() .uri("/e-commerce/Catalog/addProduct")
		 * .contentType(MediaType.APPLICATION_JSON)
		 * .req(BodyInserters.fromObject(catalogEntity)) .exchange()
		 * .expectStatus().isCreated();
		 * 
		 * //webClient.post().uri("").contentType(MediaType.APPLICATION_JSON).body(
		 * inserter)
		 * 
		 * Mockito.verify(catalogRepository, times(1)).save(catalogEntity);
		 */
    }
	
}
