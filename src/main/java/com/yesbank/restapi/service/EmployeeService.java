package com.yesbank.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yesbank.restapi.exception.EmployeeNotFoundException;
import com.yesbank.restapi.model.Employee;
import com.yesbank.restapi.model.EmployeeDTO;
import com.yesbank.restapi.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private  EmployeeRepository empRepo;
	
	
	public EmployeeDTO createEmployee(Employee emp) {
		Employee empResult = empRepo.save(emp);
		EmployeeDTO empDTO = new EmployeeDTO(empResult.getEmpId(), empResult.getName(), empResult.getEmail());
		return empDTO;
	}
	
	

	
	public List<Employee> getAllEmployees() {
		List<Employee> empResult = empRepo.findAll();
	//	EmployeeDTO empDTO = new EmployeeDTO(empResult.getEmpId(), empResult.getName(), empResult.getEmail());
		return empResult;
	}
	
	public Optional<Employee> getEmployeeById(String empId) throws EmployeeNotFoundException{
		
		try {
			Optional<Employee> empResult = empRepo.findById(empId);
			
			if(!empResult.isEmpty())
				return empResult;
		
			else
				throw new EmployeeNotFoundException(empId);
		}catch (EmployeeNotFoundException e) {
			// TODO: handle exception
			throw e;
		}
		//EmployeeDTO empDTO = new EmployeeDTO(empResult.getEmpId(), empResult.getName(), empResult.getEmail());
		
	}
	
	public void deleteEmployeeById(String empId) {
		 empRepo.deleteById(empId);
		//EmployeeDTO empDTO = new EmployeeDTO(empResult.getEmpId(), empResult.getName(), empResult.getEmail());
		//return empResult;
	}
	
	
	
	/*
	 * public Optional<Employee> getEmployeeByName(String name) { Optional<Employee>
	 * empResult = //EmployeeDTO empDTO = new EmployeeDTO(empResult.getEmpId(),
	 * empResult.getName(), empResult.getEmail()); return empResult; }
	 */

}
