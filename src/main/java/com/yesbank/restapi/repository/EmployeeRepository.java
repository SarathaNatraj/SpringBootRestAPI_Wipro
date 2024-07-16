package com.yesbank.restapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.yesbank.restapi.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String>{
	
	
	Optional<Employee> getByName(String empName);
}
