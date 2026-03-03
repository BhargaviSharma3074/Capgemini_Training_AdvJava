package com.lpu.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.boot.entity.Student;
import com.lpu.boot.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService service;
	
	@PostMapping("/student")
    public Student addStudent(@RequestBody Student student)
    {
        return service.saveStudent(student);
    }
	
	@DeleteMapping("/student")
	public String deleteStudent(@RequestBody Student student)
	{
		service.deleteStudent(student);
		return "Student deleted";
	}
	
	@DeleteMapping("/student/{id}")
	public String deleteStudentById(@RequestParam int id)
	{
		service.deleteStudentById(id);
		return "Student deleted";
	}
	
	@PostMapping("/students")
	public List<Student> saveAllStudents(@RequestBody List<Student> list)
	{
		return service.saveAllStudents(list);
	}
	
	@GetMapping("/studentbyname")
    public List<Student> getStudents(@RequestParam String name){
        return service.getStudent(name);
    }
	
	@GetMapping("/by-name-phone")
    public Student findByNameAndPhone(@RequestParam String name, @RequestParam long phone){
        return service.getStudentByNameAndPhone(name, phone);
    }
	
	@GetMapping("/native")
    public List<Student> getAllNative(){
        return service.getAll();
    }
	
	
}
