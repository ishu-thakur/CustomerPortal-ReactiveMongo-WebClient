package com.reactivemongo.ReactiveApi.services;

import com.reactivemongo.ReactiveApi.dto.EmployeeDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeServiceInterface {
     Mono<EmployeeDto> insert(EmployeeDto employeeDto);
//     Mono<EmployeeDto> update(EmployeeDto employeeDto, String id);
     Mono<EmployeeDto> getEmployeeById(String id);
     Flux<EmployeeDto> getAll();
     Mono<Void> delete(String id);
}
