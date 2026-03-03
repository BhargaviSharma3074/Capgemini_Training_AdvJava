package com.lpu.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.boot.entity.Student;
import com.lpu.boot.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repository;
	
	public Student saveStudent(Student student)
	{
		return repository.save(student);
	}
	
	public void deleteStudent(Student student)
	{
		repository.delete(student);
		System.out.println("Student deleted");
	}
	public List<Student> findAllStudents()
	{
		return repository.findAll();
	}
	public void deleteStudentById(int id)
	{
		repository.deleteById(id);
	}
	public List<Student> saveAllStudents(List<Student> list)
	{
		return repository.saveAll(list);
	}
	
	public List<Student> getStudent(String name)
	{
		return repository.findByName(name);
	}
	
	public Student getStudentByNameAndPhone(String name, long phone)
	{
		return repository.findByNameAndPhone(name, phone);
	}
	
	public List<Student> getAll()
	{
		return repository.getAllStudents();
	}
}
