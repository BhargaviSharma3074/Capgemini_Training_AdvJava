package com.lpu.service;

import java.util.List;

import com.lpu.dao.StudentDAO;
import com.lpu.entity.Courses;
import com.lpu.entity.Student;

public class StudentService {
	private StudentDAO dao = new StudentDAO();
	
	public Student registerStudent(String name, int age, double marks)
	{
		boolean checkAge = (age>17 && age<100);
		boolean checkMarks = (marks>0 && marks<=100);
		if(!checkMarks || !checkAge)
		{
			throw new IllegalArgumentException("--- Age must be >17 and <100 | Marks must be >0 and <=100 ---");
		}
		Student s = new Student(name,age,marks);
		return dao.saveStudent(s);		
	}
	
	public Student getStudent(int id)
	{
		Student s = dao.findStudent(id);
		if(s==null)
		{
			throw new IllegalArgumentException("Student not found");
		}
		
		return s;
	}
	
	public void updateMarks(int id, double newMarks)
	{
		if(newMarks<0 || newMarks>100)
		{
			throw new IllegalArgumentException("Marks must be >0 and <=100");
		}

		dao.updateStudentMarks(id, newMarks);
	}
	
	public void deleteStudent(int id)
	{
		dao.deleteStudent(id);
	}
	
	public void giveCourseToStudent(int id, Courses c)
	{
		dao.giveCourseToStudent(id, c);
	}
	
	public void giveCoursesToStudent(int id, List<Courses> courses)
	{
		dao.giveCoursesToStudent(id, courses);
	}
	
	public void findAllStudents()
	{
		dao.findAllStudent();
	}
}
