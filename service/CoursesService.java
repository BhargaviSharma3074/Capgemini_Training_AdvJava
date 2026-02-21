package com.lpu.service;

import com.lpu.dao.CoursesDAO;
import com.lpu.dao.StudentDAO;
import com.lpu.entity.Courses;
import com.lpu.entity.Student;

public class CoursesService {
private CoursesDAO dao = new CoursesDAO();
	
	public Courses addCourse(int id, String name, String teacher )
	{
		Courses c = new Courses(id,name,teacher);
		return dao.saveCourse(c);		
	}
	
	public Courses getCourses(int id)
	{
		Courses c = dao.findCourse(id);
		if(c==null)
		{
			throw new IllegalArgumentException("Course not found");
		}
		
		return c;
	}
	
	public void updateCourse(int id, String newTeacher)
	{
	
		dao.updateCourseTeacher(id, newTeacher);
	}
	
	public void deleteCourse(int id)
	{
		dao.deleteCourse(id);
	}
	
	public void findAllCourses()
	{
		dao.findAllCourses();
	}
}
