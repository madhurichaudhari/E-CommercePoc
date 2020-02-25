package com.hcl.ecommercepoc.serviceimp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommercepoc.entities.ProductOrders;
import com.hcl.ecommercepoc.repositories.OrderRepository;
import com.hcl.ecommercepoc.services.OrderService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Mono<ProductOrders> createOrder(ProductOrders productOrders) {
        return orderRepository.save(productOrders);
    }

    @Override
    public Flux<ProductOrders> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Mono<ProductOrders> updateOrder(ProductOrders productOrders, String id) {
        return findOne(id).doOnSuccess(productOrders1 -> {
          orderRepository.save(productOrders).subscribe();
        });
    }

    @Override
    public Mono<ProductOrders> findOne(String id) {
        return orderRepository.findById(id).
                switchIfEmpty(Mono.error(new Exception("No Product found with Id: " + id)));
    }


    
    
    @Override
	public Flux<ProductOrders> findById(String Id) {
		// TODO Auto-generated method stub
		return null;
	}
    

    @Override
    public Mono<Boolean> delete(String id) {
        return findOne(id).doOnSuccess(blog -> {
           // blog.setDelete(true);
        	orderRepository.deleteById(id).subscribe();
        }).flatMap(blog -> Mono.just(Boolean.TRUE));
    }
}
