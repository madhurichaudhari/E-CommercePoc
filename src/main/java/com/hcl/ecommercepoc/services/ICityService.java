package com.hcl.ecommercepoc.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import com.hcl.ecommercepoc.entities.City;

public interface ICityService {

    Mono<City> insert(City city);
    Flux<City> saveAll(List<City> cities);
    Mono<City> findById(String id);
    Flux<City> findAll();
    Mono<Void> deleteAll();
}
