package com.lpu.employeeApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpu.employeeApp.entity.Company;


public interface CompanyRepository  extends JpaRepository<Company, Integer>{
	List<Company> findByName(String name);
	
}
