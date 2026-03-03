package com.lpu.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lpu.boot.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	List<Student> findByName(String name);
	Student findByNameAndPhone(String name, long phone);
	
	@Query("select s from Student s where s.name=:name")
	List<Student> getStudentByName(String name);
	
	@Query(nativeQuery = true, value="select * from student")
	List<Student> getAllStudents();

}
