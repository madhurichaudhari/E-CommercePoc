package com.hcl.ecommercepoc.serviceimp;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.function.Predicate;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.hcl.ecommercepoc.entities.Catalog;
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
		Catalog catalogEntity = new Catalog();
		catalogEntity.setProductId("1");
		catalogEntity.setProductDescription("AB");
		Mono<Catalog> catalogData = catalogServiceImpl.addProduct(catalogEntity);
		StepVerifier.create(catalogData).assertNext(account -> assertNotNull(account.getProductId())).expectComplete()
				.verify();
	}

	@Test
	public void givenProduct_whenSave_thenFetchProduct_WhenSuccess() {
		Catalog catalogEntity = new Catalog();
		catalogEntity.setProductId("1");
		catalogEntity.setProductDescription("TV for entertainment");
		catalogEntity.setProductName("TV");
		Flux<Catalog> saved = catalogRepository.saveAll(Flux.just(catalogEntity));

		Flux<Catalog> composite = catalogServiceImpl.findAllProduct().thenMany(saved);

		Predicate<Catalog> match = catalogEntity1 -> saved.any(saveItem -> saveItem.equals(catalogEntity))
				.block();

		StepVerifier.create(composite).expectNextMatches(match).verifyComplete();

	}

}
