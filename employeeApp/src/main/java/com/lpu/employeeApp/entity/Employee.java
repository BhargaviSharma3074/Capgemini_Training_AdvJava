package com.lpu.employeeApp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@Entity
public class Employee {
	@Id
	private int id;
	@NotBlank(message = "Name must not be blank") //checks if empty/blank
	private String name;
	@Positive(message = "Phone number must be positive")
//	@Pattern(regexp = "[\\d{10}]", message = "Phone number must contain 10 digits") //pattern can only be used with String fields
	private long phone;
	@Email(message = "Email should be valid") //validates email
	private String email;
	@Min(value = 18, message = "Must be greater than 18")
	@Max(value = 60, message = "Must be less than 60")
	private int age;
	@ManyToOne
	@JsonBackReference
	private Company company;
	
	
	public Employee() {}

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

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	
}
