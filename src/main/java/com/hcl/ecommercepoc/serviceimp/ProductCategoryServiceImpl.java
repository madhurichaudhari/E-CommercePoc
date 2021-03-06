package com.hcl.ecommercepoc.serviceimp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommercepoc.entities.Catalog;
import com.hcl.ecommercepoc.entities.ProductCategory;
import com.hcl.ecommercepoc.repositories.CatalogRepository;
import com.hcl.ecommercepoc.repositories.ProductCategoryRepository;
import com.hcl.ecommercepoc.services.CatalogService;
import com.hcl.ecommercepoc.services.ProductCategoryService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public Mono<ProductCategory> addCategory(ProductCategory productCategoryEntity) {
        return productCategoryRepository.save(productCategoryEntity);
    }

    @Override
    public Flux<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public Mono<ProductCategory> updateCategory(ProductCategory productCategoryEntity, String id) {
        return findOne(id).doOnSuccess(productOrders1 -> {
          productCategoryRepository.save(productCategoryEntity).subscribe();
        });
    }

    @Override
    public Mono<ProductCategory> findOne(String id) {
        return productCategoryRepository.findById(id).
                switchIfEmpty(Mono.error(new Exception("No Product found with Id: " + id)));
    }


    
    
    @Override
	public Flux<ProductCategory> findById(String Id) {
		// TODO Auto-generated method stub
		return null;
	}
    

    @Override
    public Mono<Boolean> delete(String id) {
        return findOne(id).doOnSuccess(blog -> {
           // blog.setDelete(true);
        	productCategoryRepository.deleteById(id).subscribe();
        }).flatMap(blog -> Mono.just(Boolean.TRUE));
    }
}
