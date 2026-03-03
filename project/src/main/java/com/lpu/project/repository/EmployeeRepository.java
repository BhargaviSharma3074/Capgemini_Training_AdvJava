package com.lpu.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lpu.project.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	List<Employee> findByName(String name);
	List<Employee> findByDepartment(String department);
	List<Employee> findByPhone(long phone);
	List<Employee> findByEmail(String email);
	
}
