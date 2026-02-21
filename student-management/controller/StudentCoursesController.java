package com.lpu.controller;

import java.util.Arrays;

import com.lpu.entity.Courses;
import com.lpu.entity.Student;
import com.lpu.service.CoursesService;
import com.lpu.service.StudentService;

public class StudentCoursesController {
	private static StudentService service = new StudentService();
	private static CoursesService cservice = new CoursesService();
	public static void main(String[] args) {
//		
//		service.registerStudent("Bhavya", 21, 85);
//		service.registerStudent("Sanjana", 20, 75);
		
//		cservice.addCourse(102, "SQL", "Vaishnav");
//		cservice.addCourse(103, "Adv Java", "Sandeep Chavan");
		
//		cservice.addCourse(104, "XYZ", "ABC");
//		service.registerStudent("A",21,98);
		
		Courses c1 = cservice.getCourses(101);
		Courses c2 = cservice.getCourses(102);
		Courses c3 = cservice.getCourses(103);
		Courses c4 = cservice.getCourses(104);
		
		service.giveCourseToStudent(2, c2);
		service.giveCoursesToStudent(3, Arrays.asList(c1,c2,c3));
		service.giveCourseToStudent(4, c4);
		service.giveCourseToStudent(2, c3);
		
//		
//		service.updateMarks(2, 90);
//		cservice.updateCourse(104, "New Name");
//		
//		
//		service.findAllStudents();
//		cservice.findAllCourses();
//		
//		service.deleteStudent(4);
//		cservice.deleteCourse(104);
		
		service.findAllStudents();
		cservice.findAllCourses();
		
		
	}

}
