package com.lpu.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lpu.entity.Department;
import com.lpu.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

@Component
public class StudentDAO {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	
	public void addStudent(Student student)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(student);
		et.commit();
		em.close();
	}
	public void assignStudentToDepartment(int deptid, Student student)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Department d = em.find(Department.class, deptid);		
		et.begin();
		if (d != null) {
	        student.setDepartment(d);
	        em.merge(student);
	    } else {
	        System.out.println("Department not found");
	    }
		et.commit();
		em.close();
		
		
		
	}
	public List<Student> viewStudentsByDepartment(int id)
	{
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT s FROM Student s where s.department.id=:id");
		q.setParameter("id",id);
		return q.getResultList();
	}
	public void udpateStudent(int id, String newEmail)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Student s = em.find(Student.class, id);
		et.begin();
		s.setEmail(newEmail);
		em.merge(s);
		et.commit();
		em.close();
	}
	public void deleteStudent(int id)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Student s = em.find(Student.class, id);
		et.begin();
		if(s!=null)
		{
			em.remove(s);
		}
		et.commit();
		em.close();
	}
	
}
