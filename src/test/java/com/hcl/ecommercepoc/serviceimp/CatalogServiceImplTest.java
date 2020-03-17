package com.hcl.ecommercepoc.serviceimp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.StringUtils;
import com.google.gson.Gson;
import com.hcl.ecommercepoc.entities.CatalogEntity;
import com.hcl.ecommercepoc.repositories.CatalogRepository;
import com.hcl.ecommercepoc.responsemodels.inventory.InventoryDetails;
import com.hcl.ecommercepoc.responsemodels.inventory.InventoryModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CatalogServiceImplTest {

	@Inject
	private CatalogServiceImpl catalogServiceImpl;
	@Inject
	private CatalogRepository catalogRepository;

	@Test
	public void givenProduct_whenSave_thenSaveProduct_WhenSucces() {
		CatalogEntity catalogEntity = new CatalogEntity();
		catalogEntity.setProductId("1");
		catalogEntity.setProductDescription("AB");
		Mono<CatalogEntity> catalogData = catalogServiceImpl.addProduct(catalogEntity);
		StepVerifier.create(catalogData).assertNext(account -> assertNotNull(account.getProductId())).expectComplete()
				.verify();
	}

	@Test
	public void givenProduct_whenSave_thenFetchProduct_WhenSuccess() {
		// Flux<CatalogEntity> saved =
		// catalogRepository.saveAll(Flux.just(catalogEntity));
		Flux<CatalogEntity> saved = catalogRepository.saveAll(Flux.just(new CatalogEntity(null, "Josh"),
				new CatalogEntity(null, "Matt"), new CatalogEntity(null, "Jane")));
		Flux<CatalogEntity> composite = catalogServiceImpl.findAllProduct().thenMany(saved);
		Predicate<CatalogEntity> match = catalogEntity1 -> saved.any(saveItem -> saveItem.equals(catalogEntity1))
				.block();
		StepVerifier.create(composite).expectNextMatches(match).expectNextMatches(match).expectNextMatches(match)
				.verifyComplete();

	}

	@Test
	public void delete() {
		CatalogEntity catalogEntity = new CatalogEntity();
		catalogEntity.setProductId("1");
		catalogEntity.setProductDescription("AB");

		Mono<CatalogEntity> deleted = catalogServiceImpl.addProduct(catalogEntity)
				.flatMap(saved -> catalogServiceImpl.delete(saved.getProductId()));

		StepVerifier.create(deleted).expectNextMatches(profile -> profile.getProductName().equalsIgnoreCase("AB"))
				.verifyComplete();
	}

	@Test
	public void update() throws Exception {
		CatalogEntity catalogEntity = new CatalogEntity();
		catalogEntity.setProductId("1");
		catalogEntity.setProductDescription("AB");
		Mono<CatalogEntity> saved = catalogServiceImpl.addProduct(catalogEntity)
				.flatMap(p -> catalogServiceImpl.updateProduct(catalogEntity, p.getProductId()));
		StepVerifier.create(saved).expectNextMatches(p -> p.getProductName().equalsIgnoreCase("AB")).verifyComplete();
	}

	@Test
	public void getById() {
		CatalogEntity catalogEntity = new CatalogEntity();
		catalogEntity.setProductId("1");
		catalogEntity.setProductDescription("AB");
		String test = UUID.randomUUID().toString();
		Mono<CatalogEntity> deleted = catalogServiceImpl.addProduct(catalogEntity)
				.flatMap(saved -> catalogServiceImpl.findProductById(saved.getProductId()));
		StepVerifier.create(deleted).expectNextMatches(profile -> StringUtils.hasText(profile.getProductId())
				&& test.equalsIgnoreCase(profile.getProductName())).verifyComplete();
	}

	@Test
	public void testInventory_whenSuccess() {

		InventoryModel inventoryDetail = catalogServiceImpl.checkInventory();
		assertThat(inventoryDetail.getStatus()).isEqualTo(true);
		assertThat(inventoryDetail.getMessage()).isEqualTo("success");
		assertThat(inventoryDetail.getQuantityModel().getQuantity()).isEqualTo(2);

	}
	
	
	
	@Test
	public void testInventory_whenQuantityNegative() {
		Gson gson = new Gson();
    	String json = "{\"data\":{\"id\":17,\"productID\":\"202\",\"quantity\":-1},\"message\":\"success\",\"status\":true,\"statusCode\":200}\r\n"
				+ "";
    	//InventoryModel person = new Gson().fromJson(json, InventoryModel.class);
    	InventoryModel inventoryDetail = new Gson().fromJson(json, InventoryModel.class);
    	    assertThat(inventoryDetail.getStatus()).isEqualTo(true);
    	    assertThat(inventoryDetail.getMessage()).isEqualTo("success");
    	    assertThat(inventoryDetail.getQuantityModel().getQuantity()).isEqualTo(-1);

	}
	
	@Test
	public void testInventory_whenZeo() {
		Gson gson = new Gson();
    	String json = "{\"data\":{\"id\":17,\"productID\":\"202\",\"quantity\":0},\"message\":\"success\",\"status\":true,\"statusCode\":200}\r\n"
				+ "";
    	//InventoryModel person = new Gson().fromJson(json, InventoryModel.class);
    	InventoryModel inventoryDetail = new Gson().fromJson(json, InventoryModel.class);
    	    assertThat(inventoryDetail.getStatus()).isEqualTo(true);
    	    assertThat(inventoryDetail.getMessage()).isEqualTo("success");
    	    assertThat(inventoryDetail.getQuantityModel().getQuantity()).isEqualTo(0);

	}
	
	
	@Test
	public void testAllInventory_whenSuccess() {
		
		List<InventoryDetails> inventoryDetailList = catalogServiceImpl.checkAllInventoryQuantity();

    	//InventoryModel person = new Gson().fromJson(json, InventoryModel.class);
    	    assertThat(inventoryDetailList.get(0).getQuantity()).isEqualTo(1);
    	    assertThat(inventoryDetailList.get(1).getQuantity()).isEqualTo(2);

	}
	

}
