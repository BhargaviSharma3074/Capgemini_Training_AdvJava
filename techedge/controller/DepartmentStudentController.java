package com.lpu.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.lpu.MyConfig;
import com.lpu.entity.Department;
import com.lpu.entity.Student;
import com.lpu.service.DepartmentService;
import com.lpu.service.StudentService;


@Component(value = "dsc")
public class DepartmentStudentController {
	
	
	public static void main(String[] args)
	{
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		DepartmentService ds = context.getBean("dservice",DepartmentService.class);
        StudentService ss = context.getBean("sservice",StudentService.class);
        
//        Department d = new Department();
//
//        d.setName("Computer Science");
//        ds.addDepartment(d);
//        Department d1 = new Department();
//
//        d1.setName("Business Administration");
//        ds.addDepartment(d1);
//        
//        Student s = new Student();
//        s.setName("Bhargavi");
//        s.setEmail("bhargavi@gmail.com");
//        
//        Student s1 = new Student();
//        s1.setName("Bhavya");
//        s1.setEmail("bhavya@gmail.com");
////        
//        ss.addStudent(s);
        
//        ss.assignStudentToDepartment(2, s1);
         
//        ss.deleteStudent(2);
//        ds.deleteDepartment(3);

        for(Student s : ss.viewStudentsByDepartment(2))
        {
        	System.out.println("ID: "+s.getId()+", Name: "+s.getName()+", Email: "+s.getEmail()+", Department: "+s.getDepartment());
        	
        }
       
        
        
        
		
		
	}
}
