package com.lpu.employeeApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.employeeApp.entity.Company;
import com.lpu.employeeApp.entity.Employee;
import com.lpu.employeeApp.service.CompanyService;

@RestController
public class CompanyController {
	@Autowired
	private CompanyService service;
	
	@PostMapping("/company")
	public ResponseEntity<Company> saveCompany(@RequestBody Company company)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addCompany(company));
	}
	
	@PostMapping("/company2")
	public ResponseEntity<Company> saveCompAndMapEmp(@RequestBody Company company)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveCompAndMapEmp(company));
	}
	
	@PostMapping("/company3/{compId}")
	public ResponseEntity<Company> saveEmpToExistingComp(@PathVariable int compId, @RequestBody List<Employee> emps)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveEmpToExistingComp(compId, emps));
	}
	
	@GetMapping("/company/{cid}")
	public Company findCompById(@PathVariable int cid)
	{
		return service.findCompanyById(cid);
	}
	
}
