package com.lpu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.dao.StudentDAO;
import com.lpu.entity.Student;

@Component(value = "sservice")
public class StudentService {
	@Autowired
    private StudentDAO studentDAO;

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        studentDAO.addStudent(student);
    }

    public void assignStudentToDepartment(int deptId, Student student) {
        if (deptId <= 0) {
            throw new IllegalArgumentException("Invalid Department ID");
        }
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        studentDAO.assignStudentToDepartment(deptId, student);
    }

    public List<Student> viewStudentsByDepartment(int deptId) {
        if (deptId <= 0) {
            throw new IllegalArgumentException("Invalid Department ID");
        }
        return studentDAO.viewStudentsByDepartment(deptId);
    }

    public void updateStudent(int id, String newEmail) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid Student ID");
        }
        if (newEmail == null || newEmail.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        studentDAO.udpateStudent(id, newEmail);
    }

    public void deleteStudent(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid Student ID");
        }
        studentDAO.deleteStudent(id);
    }
}
