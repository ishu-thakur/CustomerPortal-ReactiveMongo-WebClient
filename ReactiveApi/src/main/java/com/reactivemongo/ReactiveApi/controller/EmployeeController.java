package com.reactivemongo.ReactiveApi.controller;

import com.reactivemongo.ReactiveApi.dto.EmployeeDto;
import com.reactivemongo.ReactiveApi.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@PostMapping("/employee")
	public Mono<EmployeeDto> insertEmployee(@RequestBody EmployeeDto employeeDto) {
		return service.insert(employeeDto);
	}

	@GetMapping("/employee/{id}")
	public Mono<EmployeeDto> getEmployeeById(@PathVariable String id) {

		return service.getEmployeeById(id);
	}

	@GetMapping("/employee/findAll")
	public Flux<EmployeeDto> getAll() {
		return service.getAll();
	}

//	@PutMapping("/update/{id}")
//	public Mono<EmployeeDto> updateEmployee(@RequestBody Mono<EmployeeDto> employeeDto , @PathVariable String id) {
//		return service.update(employeeDto, id);
//	}

	@DeleteMapping("/employee/delete/{id}")
	public Mono<Void> deleteEmployee(@PathVariable String id) {
		return service.delete(id);
	}
}
