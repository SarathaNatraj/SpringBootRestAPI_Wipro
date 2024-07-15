package com.yesbank.restapi.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.yesbank.restapi.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String>{
	
	
	Optional<Employee> getByName(String empName);
}
