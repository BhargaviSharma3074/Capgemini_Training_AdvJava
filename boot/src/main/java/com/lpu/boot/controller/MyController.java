package com.lpu.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.boot.entity.Student;

@RestController
public class MyController {
	@GetMapping("/hi")
	public String takeReq()
	{
		return "byeeeee";
	}
	
	//GET //http://localhost:8080/takeData?id=10&name=Bhavya 
	@GetMapping("/takeData")
	public String takeData(@RequestParam int id, @RequestParam String name)
	{
		return "ID: "+id+" | Name: "+name;
	}
	
	
	//GET //http://localhost:8080/takeData2/10/Bhavya
	@GetMapping("/takeData2/{id}/{name}")
	public String takeData2(@PathVariable int id, @PathVariable String name)
//	public String takeData2(@PathVariable(value = "id") int studentid)
	{
		return "ID: "+id+" | Name: "+name;
	}
	
	
	@GetMapping("/college")
	public String collegeData(@RequestParam int id, @RequestParam String name, @RequestParam String location)
	{
		return "ID: "+id+" | College: "+name+" | Location: "+location; 
	}
	
	

	@GetMapping("/student/{sid}/college/{cid}")
	public String takeData3(@PathVariable int sid, @PathVariable int cid)
	{
		return "SID: "+sid+" | CID: "+cid;
	}
//	@GetMapping("/student/college/{cid}")
//	public String takeData4(@RequestParam int sid, @PathVariable int cid)
//	{
//		return "SID: "+sid+" | CID: "+cid;
//	}
	
	@GetMapping("/takeData3")
	public String takeData4(@RequestHeader int id, @RequestHeader String name)
	{
		return "ID: "+id+" | Name: "+name;
	}
	
	@GetMapping("/student")
	public String getStudent(@RequestBody Student s)
	{
		System.out.println(s.getId());
		System.out.println(s.getName());
		System.out.println(s.getPhone());
		return s.getName()+" is received";
	}
	
	@GetMapping("/student1")
	public Student getStudent1(@RequestBody Student s)
	{
		return s;
	}
	
}
