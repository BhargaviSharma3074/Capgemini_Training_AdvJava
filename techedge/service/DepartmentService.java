package com.lpu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.dao.DepartmentDAO;
import com.lpu.entity.Department;

@Component(value = "dservice")
public class DepartmentService {

	@Autowired
	private DepartmentDAO departmentDAO;


	public void addDepartment(Department dept) {
		if (dept == null) {
			throw new IllegalArgumentException("Department cannot be null");
		}
		departmentDAO.addDepartment(dept);
	}

	public Department getDepartmentById(int id) {
		if (id <= 0) {
			throw new IllegalArgumentException("Invalid Department ID");
		}
		return departmentDAO.getDepartmentById(id);
	}

	public void deleteDepartment(int id) {
		if (id <= 0) {
			throw new IllegalArgumentException("Invalid Department ID");
		}
		departmentDAO.deleteDepartment(id);
	}
}
