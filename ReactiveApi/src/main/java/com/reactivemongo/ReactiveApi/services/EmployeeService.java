package com.reactivemongo.ReactiveApi.services;

import com.reactivemongo.ReactiveApi.dto.EmployeeDto;
import com.reactivemongo.ReactiveApi.mappers.mapper;
import com.reactivemongo.ReactiveApi.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService implements EmployeeServiceInterface {
	@Autowired
	public EmployeeRepo employeeRepo;


	public Mono<EmployeeDto> insert(EmployeeDto employeeDto) {
		return employeeRepo.save(mapper.INSTANCE.dtoToEntity(employeeDto))
				.map(mapper.INSTANCE::entityToDto);
	}
//********************************WRONG****************************************************
//	public Mono<EmployeeDto> update(Mono<EmployeeDto> employeeDto, String id) {
//		return employeeRepo.findById(id)
//				.flatMap(a-> {
//					a.setName(employeeDto);
//				})
//				.flatMap(p -> employeeDto)
//				.map(AppUtils::dtoToEntity)
//				.doOnNext(e -> e.setId(id))
//				.flatMap(employeeRepo::save)
//				.map(AppUtils::entityToDto);
//	}
//	public Mono<User> updateUser(Integer userId,  User user){
//		return userRepository.findById(userId)
//				.flatMap(dbUser -> {
//					dbUser.setAge(user.getAge());
//					dbUser.setSalary(user.getSalary());
//					return userRepository.save(dbUser);
//				});
//	}
//*********************************************************************************************
//	public Mono<EmployeeDto> update(EmployeeDto employeeDto, String id) {
//		return employeeRepo.findById(id)
//				.flatMap(employeeDto->{
//					employeeDto.setAge(employeeDto.getAge());
//					employeeDto.setName(employeeDto.getName());
//					return employeeRepo.save(employeeDto);
//				})
//	}

	public Mono<EmployeeDto> getEmployeeById(String id) {

		return employeeRepo.findById(id).map(mapper.INSTANCE::entityToDto);
	}

	public Flux<EmployeeDto> getAll() {

		return employeeRepo.findAll().map(mapper.INSTANCE::entityToDto);
	}

	public Mono<Void> delete(String id) {

		return employeeRepo.deleteById(id);
	}
}
