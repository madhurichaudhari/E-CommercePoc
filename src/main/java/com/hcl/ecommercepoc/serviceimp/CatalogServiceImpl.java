package com.hcl.ecommercepoc.serviceimp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommercepoc.entities.CatalogEntity;
import com.hcl.ecommercepoc.repositories.CatalogRepository;
import com.hcl.ecommercepoc.services.CatalogService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private CatalogRepository orderRepository;

    @Override
    public Mono<CatalogEntity> addProduct(CatalogEntity productOrders) {
        return orderRepository.save(productOrders);
    }

    @Override
    public Flux<CatalogEntity> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Mono<CatalogEntity> updateProduct(CatalogEntity productOrders, String id) {
        return findOne(id).doOnSuccess(productOrders1 -> {
          orderRepository.save(productOrders).subscribe();
        });
    }

    @Override
    public Mono<CatalogEntity> findOne(String id) {
        return orderRepository.findById(id).
                switchIfEmpty(Mono.error(new Exception("No Product found with Id: " + id)));
    }


    
    
    @Override
	public Flux<CatalogEntity> findById(String Id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public Flux<Catalog> findAllProductTest() {

		List<InventoryDetails> inventoryList = checkAllInventoryQuantity();
		Flux<Catalog> catalogList = null;
		for (int i = 0; i < inventoryList.size(); i++) {
			final int count = 0 + i;
			Integer qunatity = inventoryList.get(i).getQuantity();
			catalogList = catalogRepository.findAll();

			catalogList.map(it -> inventoryList.get(count).getQuantity());

		}

		catalogRepository.saveAll(catalogList);
		return catalogList;

	}
    

    @Override
    public Mono<Boolean> delete(String id) {
        return findOne(id).doOnSuccess(blog -> {
           // blog.setDelete(true);
        	orderRepository.deleteById(id).subscribe();
        }).flatMap(blog -> Mono.just(Boolean.TRUE));
    }
}
