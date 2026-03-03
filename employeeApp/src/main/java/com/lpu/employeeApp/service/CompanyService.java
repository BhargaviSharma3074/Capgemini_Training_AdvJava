package com.lpu.employeeApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.employeeApp.entity.Company;
import com.lpu.employeeApp.entity.Employee;
import com.lpu.employeeApp.exception.CompanyNotFoundException;
import com.lpu.employeeApp.repository.CompanyRepository;



@Service
public class CompanyService {
	@Autowired
	private CompanyRepository repository;
	
	
	public Company addCompany(Company company)
	{
		return repository.save(company);
	}
	
	public List<Company> getAllCompanies()
	{
		return repository.findAll(); 
	}
	
	public Optional<Company> getCompanyById(int id)
	{
		return repository.findById(id);
	}
	
	public String deleteCompanyById(int id)
	{
		repository.deleteById(id);
		return "Company Deleted";
	}
	
	public List<Company> getByName(String name)
	{
		return repository.findByName(name);
	}
	
	public List<Company> saveAllCompanies(List<Company> comps)
	{
		return repository.saveAll(comps);
	}
	
	public Company saveCompAndMapEmp(Company company)
	{
	    if(company.getEmployees() != null)
	    {
	        company.getEmployees().forEach(emp -> emp.setCompany(company));
	    }
	    return repository.save(company);
	}
	
	public Company saveEmpToExistingComp(int companyId, List<Employee> newEmp)
	{
		Company company = repository.findById(companyId).orElse(null);
		company.getEmployees().addAll(newEmp);
		return saveCompAndMapEmp(company);
				
	}
	
	public Company findCompanyById(int cid)
	{
		return repository.findById(cid).orElseThrow(
				()->new CompanyNotFoundException("Company not found!"));
	}
}

