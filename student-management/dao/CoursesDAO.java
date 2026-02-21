package com.lpu.dao;

import java.util.List;

import com.lpu.entity.Courses;
import com.lpu.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class CoursesDAO {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	
	public Courses saveCourse(Courses c)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(c);
		et.commit();
		em.close();
		return c;
	}
	
	public void updateCourseTeacher(int id, String newTeacher) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Courses c = em.find(Courses.class, id);

		et.begin();
		if (c != null) {
			c.setTeacher(newTeacher);
			em.merge(c);
		}
		et.commit();
		em.close();

		System.out.println("Teacher updated!");

	}
	
	public Courses findCourse(int id) {
		EntityManager em = emf.createEntityManager();
		Courses c = em.find(Courses.class, id);
		em.close();
		return c;
	}

	public void deleteCourse(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Courses c = em.find(Courses.class,id);
		et.begin();
		if (c != null)
			em.remove(c);
		em.close();
		et.commit();

		System.out.println("Course deleted!");

	}
	
	public void findAllCourses()
	{
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT c FROM Courses c");
		List<Courses> clist = q.getResultList();
		for(Courses c : clist)
		{
			System.out.println("Course ID: "+c.getId()+", Course Name: "+c.getName()+", Teacher: "+c.getTeacher());
		}
		em.close();
	}

}
