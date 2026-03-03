package com.lpu.boot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lpu")
@RestController
public class LpuController {
	@RequestMapping("/m1")
	public String m1()
	{
		return "m1 method";
	}
	@PostMapping("/student")
	public String saveStudent()
	{
		return "student saved";
	}
	@PostMapping("/trainer")
	public String saveTrainer()
	{
		return "Trainer saved";
	}
	@PostMapping("/security")
	public String saveSecurity()
	{
		return "Security saved";
	}
}
