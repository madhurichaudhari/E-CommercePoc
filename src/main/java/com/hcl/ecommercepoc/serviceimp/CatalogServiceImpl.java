package com.hcl.ecommercepoc.serviceimp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hcl.ecommercepoc.entities.CatalogEntity;
import com.hcl.ecommercepoc.repositories.CatalogRepository;
import com.hcl.ecommercepoc.responsemodels.InventoryModel;
import com.hcl.ecommercepoc.services.CatalogService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private CatalogRepository catalogRepository;

    @Override
    public Mono<CatalogEntity> addProduct(CatalogEntity productOrders) {
        return catalogRepository.save(productOrders);
    }

    @Override
    public Flux<CatalogEntity> findAll() {
        return catalogRepository.findAll();
    }

    @Override
    public Mono<CatalogEntity> updateProduct(CatalogEntity productOrders, String id) {
        return findOne(id).doOnSuccess(productOrders1 -> {
          catalogRepository.save(productOrders).subscribe();
        });
    }

    @Override
    public Mono<CatalogEntity> findOne(String id) {
        return catalogRepository.findById(id).
                switchIfEmpty(Mono.error(new Exception("No Product found with Id: " + id)));
    }


    
    
    @Override
	public Flux<CatalogEntity> findById(String Id) {
		// TODO Auto-generated method stub
		return null;
	}
    

    @Override
    public Mono<Boolean> delete(String id) {
        return findOne(id).doOnSuccess(blog -> {
           // blog.setDelete(true);
        	catalogRepository.deleteById(id).subscribe();
        }).flatMap(blog -> Mono.just(Boolean.TRUE));
    }

	@Override
	public Mono<String> checkInventory() {
		
		InventoryModel inventoryModel = new RestTemplate().getForObject(
				"http://10.110.244.83:7001/inventory/Item/202", InventoryModel.class); 
		
		System.out.println("inventoryModel"+inventoryModel);
		
		
		return null;
	}
}
