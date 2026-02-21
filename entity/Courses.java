package com.lpu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Courses {
	@Id
	private int id;
	private String name;
	private String teacher;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
	
	public Courses(int id, String name, String teacher) {
		super();
		this.id = id;
		this.name = name;
		this.teacher = teacher;
	}
	public Courses() {}

	

}
