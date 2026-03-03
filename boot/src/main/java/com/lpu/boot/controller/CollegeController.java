package com.lpu.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.boot.entity.College;
import com.lpu.boot.service.CollegeService;

@RestController
public class CollegeController {
	@Autowired
	private CollegeService service;
	
	@PostMapping("/college/save")
	public College saveCollege(@RequestBody College college)
	{
		return service.saveCollege(college);
	}
	
	@PostMapping("/college/savemany")
	public List<College> saveAllColleges(@RequestBody List<College> list)
	{
		return service.saveAllColleges(list);
	}
	
	@DeleteMapping("/college/delete")
	public String deleteCollege(@RequestBody College college)
	{
		service.deleteCollege(college);
		return "College deleted";
	}
	
	@DeleteMapping("/college/deletebyid")
	public String deleteCollegeById(@RequestParam int id)
	{
		service.deleteCollegeById(id);
		return "College deleted";
	}
	
	@GetMapping("/colleges")
	public List<College> findAllColleges()
	{
		return service.findAllColleges();
	}
	
}
