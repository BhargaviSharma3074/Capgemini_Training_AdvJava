package com.lpu.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.boot.entity.College;
import com.lpu.boot.repository.CollegeRepository;


@Service
public class CollegeService {
	@Autowired
	private CollegeRepository repository;
	
	public College saveCollege(College college)
	{
		return repository.save(college);
	}
	
	public void deleteCollege(College college)
	{
		repository.delete(college);
		System.out.println("College deleted");
	}
	public List<College> findAllColleges()
	{
		return repository.findAll();
	}
	public void deleteCollegeById(int id)
	{
		repository.deleteById(id);
	}
	public List<College> saveAllColleges(List<College> list)
	{
		return repository.saveAll(list);
	}
	
	

}
