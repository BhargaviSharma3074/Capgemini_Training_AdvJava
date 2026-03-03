package com.lpu.employeeApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.employeeApp.dto.EmployeeDTO;
import com.lpu.employeeApp.entity.Employee;
import com.lpu.employeeApp.exception.EmployeeNotFoundException;
import com.lpu.employeeApp.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;
	
	public EmployeeDTO addEmployee(EmployeeDTO dto)
	{
		Employee e = repository.save(DTOToEntity(dto));
		return entityToDTO(e);
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
	
	public List<Employee> getByPhone(long phone)
	{
		return repository.findByPhone(phone);
	}
	public List<Employee> getByEmail(String email)
	{
		return repository.findByEmail(email);
	}
	
	public Employee findEmpById(int id)
	{
		Employee e = repository.findById(id).orElseThrow(
				() -> new EmployeeNotFoundException("Employee is not present in database.")
				);
		return e;
	}
	
//	===============================================================================================================
	
	public EmployeeDTO entityToDTO(Employee emp)
	{
		EmployeeDTO dto = new EmployeeDTO();
		dto.setAge(emp.getAge());
		dto.setEmail(emp.getEmail());
		dto.setName(emp.getName());
		dto.setPhone(emp.getPhone());
		
		return dto;
	}
	
	public Employee DTOToEntity(EmployeeDTO dto)
	{
		Employee e = new Employee();
		e.setAge(dto.getAge());
		e.setName(dto.getName());
		e.setEmail(dto.getEmail());
		e.setPhone(dto.getPhone());
		
		return e;
	}
	
}
