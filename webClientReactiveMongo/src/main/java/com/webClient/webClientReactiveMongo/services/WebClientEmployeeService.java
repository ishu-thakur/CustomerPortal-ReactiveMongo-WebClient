package com.webClient.webClientReactiveMongo.services;


import com.webClient.webClientReactiveMongo.model.WebClientEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class WebClientEmployeeService implements WebClientEmployeeServiceInterface{
    @Autowired
    private WebClient webClient;

    @Override
    public Mono<WebClientEmployee> insert(WebClientEmployee employee){
        return webClient.post().uri("/employee")
                .bodyValue(employee)
                .retrieve().bodyToMono(WebClientEmployee.class)
                .timeout(Duration.ofMillis(10_000));
    }


    //  public Mono<WebClientEmployee> update(WebClientEmployee employee, String id);

    public Mono<WebClientEmployee> getEmployeeById(String id){
        return webClient.get().uri("/employee/{id}",id)
                .retrieve().bodyToMono(WebClientEmployee.class);
    }


    public Flux<WebClientEmployee> getAll(){
        return webClient.get().uri("/employee/findAll")
                .retrieve().bodyToFlux(WebClientEmployee.class);
    }


    public Mono<Void> delete(String id) {
        return webClient.delete().uri("/employee/delete/{id}",id)
                .retrieve().bodyToMono(Void.class);
    }

}
