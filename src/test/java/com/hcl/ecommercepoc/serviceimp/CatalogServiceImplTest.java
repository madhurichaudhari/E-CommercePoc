package com.hcl.ecommercepoc.serviceimp;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.function.Predicate;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.hcl.ecommercepoc.entities.CatalogEntity;
import com.hcl.ecommercepoc.repositories.CatalogRepository;
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
		CatalogEntity catalogEntity = new CatalogEntity();
		catalogEntity.setProductId("1");
		catalogEntity.setProductDescription("TV for entertainment");
		catalogEntity.setProductName("TV");
		Flux<CatalogEntity> saved = catalogRepository.saveAll(Flux.just(catalogEntity));

		Flux<CatalogEntity> composite = catalogServiceImpl.findAllProduct().thenMany(saved);

		Predicate<CatalogEntity> match = catalogEntity1 -> saved.any(saveItem -> saveItem.equals(catalogEntity))
				.block();

		StepVerifier.create(composite).expectNextMatches(match).verifyComplete();

	}

}
