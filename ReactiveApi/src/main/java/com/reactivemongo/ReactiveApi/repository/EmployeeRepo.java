package com.reactivemongo.ReactiveApi.repository;

import com.reactivemongo.ReactiveApi.model.Employee;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends ReactiveMongoRepository<Employee, String> {
}
