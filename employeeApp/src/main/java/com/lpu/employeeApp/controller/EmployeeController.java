package com.lpu.employeeApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.employeeApp.dto.EmployeeDTO;
import com.lpu.employeeApp.entity.Employee;
import com.lpu.employeeApp.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/employee/add")
	public ResponseEntity<EmployeeDTO> addEmp(@Valid @RequestBody EmployeeDTO employee)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addEmployee(employee));
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmps()
	{
		return service.getAllEmployees();
	}
	
	@GetMapping("/employeesbyid")
	public Optional<Employee> getEmpById(@RequestParam int id)
	{
		return service.getEmployeeById(id);
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmp(@PathVariable int id)
	{
		return service.deleteEmployeeById(id);
	}
	
	@GetMapping("/employees/searchname")
	public List<Employee> getByName(@RequestParam String name)
	{
		return service.getByName(name);
	}
	
	@GetMapping("/employees/searchphone")
	public List<Employee> getByPhone(@RequestParam long phone)
	{
		return service.getByPhone(phone);
	}
	@GetMapping("/employees/searchemail")
	public List<Employee> getByEmail(@RequestParam String email)
	{
		return service.getByEmail(email);
	}
	
	@GetMapping("/divide/{num1}/{num2}")
	public float divide(@PathVariable int num1, @PathVariable int num2)
	{
		return num1/num2;
	}
	
	@GetMapping("/employee/{id}")
	public Employee findEmpById(@PathVariable int id)
	{
		return service.findEmpById(id);
	}
	
	
}
