package com.lpu.dao;


import org.springframework.stereotype.Component;

import com.lpu.entity.Department;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

@Component
public class DepartmentDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");

	public void addDepartment(Department dept) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(dept);
		et.commit();
		em.close();
	}

	public Department getDepartmentById(int id) {
		EntityManager em = emf.createEntityManager();
		Department d = em.find(Department.class, id);
		em.close();
		return d;
	}

	public void deleteDepartment(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Department d = em.find(Department.class, id);

		et.begin();
		if (d != null) {
			em.remove(d);
		}
		et.commit();
		em.close();
	}
}
