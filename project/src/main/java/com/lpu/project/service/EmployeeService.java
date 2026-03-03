package com.lpu.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.project.entity.Employee;
import com.lpu.project.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;
	
	public Employee addEmployee(Employee employee)
	{
		return repository.save(employee);
	}
	
	public List<Employee> getAllEmployees()
	{
		return repository.findAll(); 
	}
	
	public Optional<Employee> getEmployeeById(int id)
	{
		return repository.findById(id);
	}
	
	public String deleteEmployeeById(int id)
	{
		repository.deleteById(id);
		return "Employee Deleted";
	}
	
	public List<Employee> getByName(String name)
	{
		return repository.findByName(name);
	}
	
	public List<Employee> getByDepartment(String department)
	{
		return repository.findByDepartment(department);
	}
	public List<Employee> getByPhone(long phone)
	{
		return repository.findByPhone(phone);
	}
	public List<Employee> getByEmail(String email)
	{
		return repository.findByEmail(email);
	}
	
	
}
