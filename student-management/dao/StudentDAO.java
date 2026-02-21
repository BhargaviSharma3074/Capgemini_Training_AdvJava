package com.lpu.dao;

import java.util.List;

import com.lpu.entity.Courses;
import com.lpu.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;


public class StudentDAO {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");

	public Student saveStudent(Student s) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(s);
		et.commit();
		em.close();
		return s;
	}

	public void updateStudentMarks(int id, double newMarks) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Student s = findStudent(id);

		et.begin();
		if (s != null) {
			s.setMarks(newMarks);
			em.merge(s);
			System.out.println("Marks updated!");
		}
		et.commit();
		em.close();

		

	}

	public Student findStudent(int id) {
		EntityManager em = emf.createEntityManager();
		Student s = em.find(Student.class, id);
		em.close();
		return s;
	}

	public void deleteStudent(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Student s = em.find(Student.class,id);
		et.begin();
		if (s != null)
		{
			em.remove(s);
			System.out.println("Record deleted!");
		}
		em.close();
		et.commit();

		

	}
	
	public void giveCourseToStudent(int id, Courses c)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Student s = em.find(Student.class, id);
		et.begin();
		if(s!=null) {
			s.getCourses().add(c);
			System.out.println("Course assigned to student");
		}
		em.persist(s);
		et.commit();
		em.close();
		
		
		
	}
	
	public void giveCoursesToStudent(int id, List<Courses> courses)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Student s = em.find(Student.class, id);
		et.begin();
		if(s!=null) {
			for(Courses c : courses)
			{
				
			s.getCourses().add(c);
			}
			System.out.println("Courses assigned to student");
		}
		em.persist(s);
		et.commit();
		em.close();
		
		
		
	}
	
	public void findAllStudent()
	{
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT s FROM Student s");
		List<Student> slist = q.getResultList();
		for(Student s : slist)
		{
			System.out.println("Student ID: "+s.getId()+", Student Name: "+s.getName()+", Age: "+s.getAge()+", Marks: "+s.getMarks());
		}
		em.close();
	}


}
