package com.hcl.ecommercepoc.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommercepoc.ECommercePocApplication;
import com.hcl.ecommercepoc.entities.CatalogEntity;
import com.hcl.ecommercepoc.services.CatalogService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;




@RestController
@RequestMapping("/api/v1/Category")
public class CategoryController {
	

   
    
}


