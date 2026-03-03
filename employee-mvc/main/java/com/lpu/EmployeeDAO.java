package com.lpu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

@Component
public class EmployeeDAO {
	@Autowired
	private EntityManagerFactory emf;
	public void saveEmp(Employee e)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(e);
		et.commit();
		em.close();
	}
	public void updateEmp(Employee e)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		if(e!=null)
		{
			em.merge(e);
		}
		et.commit();
		em.close();
	}
	public void deleteEmp(Employee e)
	{
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		if(e!=null)
		{
			em.remove(em.merge(e));
		}
		et.commit();
		em.close();
	}
	
	public Employee findById(int id)
	{
		EntityManager em = emf.createEntityManager();
		return em.find(Employee.class, id);
	}
	
	public List<Employee> findAll()
	{
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT e FROM Employee e");
		List<Employee> list =  q.getResultList();
		return list;
	}
}
