package com.yesbank.restapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yesbank.restapi.exception.EmployeeNotFoundException;
import com.yesbank.restapi.model.Employee;
import com.yesbank.restapi.model.EmployeeDTO;
import com.yesbank.restapi.service.EmployeeService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	//@RequestMapping(value="/save", method = RequestMethod.)
	@PostMapping("/save")
	public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO emp){
		try {
			Employee newEmp = new Employee(emp.getEmpId(),emp.getName(),emp.getEmail());
			EmployeeDTO result	=	empService.createEmployee(newEmp);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO emp){
		try {
			Employee newEmp = new Employee(emp.getEmpId(),emp.getName(),emp.getEmail());
			EmployeeDTO result	=	empService.createEmployee(newEmp);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/hello")
	public ResponseEntity sayHello(){
		try {
			
		return new ResponseEntity<>("Hello  from Spring Boot REST API", HttpStatus.CREATED);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable String id) throws EmployeeNotFoundException{
		try {
			System.out.println(" GEETTT"+id);
			Optional<Employee> emp = empService.getEmployeeById(id);
			System.out.println("empp"+emp);
		return new ResponseEntity(emp, HttpStatus.CREATED);
		}catch (EmployeeNotFoundException e) {
			// TODO: handle exception
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable String id){
		try {
			 empService.deleteEmployeeById(id);
		return new ResponseEntity("Deleted Successfully with "+id, HttpStatus.CREATED);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	/*
	 * @GetMapping("/getByName") public ResponseEntity<Employee>
	 * getEmployeeByName(@RequestParam String empName){ try { Optional<Employee> emp
	 * = empService.get return new ResponseEntity(emp, HttpStatus.CREATED); }catch
	 * (Exception e) { // TODO: handle exception return new ResponseEntity<>(null,
	 * HttpStatus.INTERNAL_SERVER_ERROR); } }
	 */
	
	
	@GetMapping("/all")
	 public ResponseEntity<List<Employee>> getAllEmployees(){
	        return new ResponseEntity<List<Employee>>((List<Employee>)empService.getAllEmployees(),HttpStatus.OK);
	    }

}
