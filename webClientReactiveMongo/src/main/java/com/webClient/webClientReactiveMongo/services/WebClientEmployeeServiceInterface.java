package com.webClient.webClientReactiveMongo.services;

import com.webClient.webClientReactiveMongo.model.WebClientEmployee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WebClientEmployeeServiceInterface {
    Mono<WebClientEmployee> insert(WebClientEmployee employee);
//    Mono<WebClientEmployee> update(WebClientEmployee employee, String id);
    Mono<WebClientEmployee> getEmployeeById(String id);
    Flux<WebClientEmployee> getAll();
    Mono<Void> delete(String id);
}
