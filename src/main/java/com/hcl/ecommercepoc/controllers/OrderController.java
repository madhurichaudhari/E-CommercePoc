package com.hcl.ecommercepoc.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommercepoc.ECommercePocApplication;
import com.hcl.ecommercepoc.entities.ProductOrders;
import com.hcl.ecommercepoc.services.OrderService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@RestController
@RequestMapping("/api/v1/Order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    
    private static final Logger log=LoggerFactory.getLogger(ECommercePocApplication.class);

    @GetMapping("/getOrder")
    public String demo() {
        return "madhuri";
    }
    


    @PostMapping("/createOrder")
    public Mono<ProductOrders> create(@RequestBody ProductOrders productOrders) {
        log.debug("create Order with Order : {}", productOrders);
        return orderService.createOrder(productOrders);
    }
    
    
    @GetMapping("/getAllOrder")
    public Flux<ProductOrders> findAll() {
        log.debug("findAll getAllOrder");
        return orderService.findAll();
    }
    
    @GetMapping("/getOrderDetails/{orderId}")
    public Mono<ProductOrders> findOne(@PathVariable String orderId) {
        log.debug("findOne Order with id : {}", orderId);
        return orderService.findOne(orderId);
    }
    
    @DeleteMapping("/getDeleteOrder/{orderId}")
    public Mono<Boolean> delete(@PathVariable String orderId) {
        log.debug("delete Order with id : {}", orderId);
        return orderService.delete(orderId);
    }
    
    
    @PutMapping("/getUpdateOrder/{orderId}")
    public Mono<ProductOrders> updateProductOrder(@RequestBody ProductOrders productOrders, @PathVariable String orderId) {
        log.debug("updateBlog Order with id : {} and Order : {}", orderId, productOrders);
        return orderService.updateOrder(productOrders, orderId);
    }
    
}


