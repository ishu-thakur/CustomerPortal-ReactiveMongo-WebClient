package com.webClient.webClientReactiveMongo.controller;

import com.webClient.webClientReactiveMongo.model.WebClientEmployee;
import com.webClient.webClientReactiveMongo.services.WebClientEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class WebClientEmployeeController {

    @Autowired
    private WebClientEmployeeService employeeService;

    @GetMapping("/employee/findAll")
    public Flux<WebClientEmployee> getAllEmpData() {
        return employeeService.getAll();
    }

    @GetMapping("/employee/{id}")
    public Mono<WebClientEmployee> getEmpDataByName(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/employee/insert")
    public Mono<WebClientEmployee> saveEmpData(@RequestBody WebClientEmployee employeeModel){
        return employeeService.insert(employeeModel);
    }

//    @PutMapping("/update")
//    public Mono<WebClientEmployee> updateEmpData(@RequestBody WebClientEmployee employeeModel){
//        return employeeService.(employeeModel);
//    }

    @DeleteMapping("/employee/delete/{id}")
    public Mono<Void> deleteEmpData(@PathVariable String id){
        return employeeService.delete(id);
    }
}
