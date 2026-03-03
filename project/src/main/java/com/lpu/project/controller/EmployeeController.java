package com.lpu.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.project.entity.Employee;
import com.lpu.project.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/employee/add")
	public Employee addEmp(@RequestBody Employee employee)
	{
		return service.addEmployee(employee);
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
	
	@GetMapping("/employees/searchdept")
	public List<Employee> getByDepartment(@RequestParam String department)
	{
		return service.getByDepartment(department);
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
	
	
}
