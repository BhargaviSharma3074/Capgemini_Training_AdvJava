package com.lpu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


@Controller
public class EmpController {
	@Autowired
	private EntityManagerFactory emf;
	@Autowired
	private EmployeeDAO dao;
	
	
	@RequestMapping("/register")
	public String registerEmp(Model model)
	{
		
		model.addAttribute("employee",new Employee());
		return "registration";
	}
	 @RequestMapping("/save")
	    public String saveEmployee(@ModelAttribute Employee employee) {
	        dao.saveEmp(employee);
	        return "redirect:/displayemps";
	    }
	 
	 @RequestMapping("/delete")
	 public String deleteEmp(@ModelAttribute Employee employee) {
		 dao.deleteEmp(employee);
		 return "redirect:/displayemps";
	 }
	 
	 @RequestMapping("/update")
	 public String updateEmp(@RequestParam(name="id") int id, Model model)
	 {
		 EntityManager em = emf.createEntityManager();
		 Employee employee = em.find(Employee.class, id);
		 model.addAttribute("employee", employee);
		 return "edit";
	 }
	 
	 @RequestMapping("/mergeMethod")
	 public String mergeMethod(@ModelAttribute Employee employee)
	 {
		 dao.updateEmp(employee);
		 return "redirect:/displayemps";
	 }
	
	@RequestMapping("/displayemps")
	public String findAll(Model model)
	{
		List<Employee> emps = dao.findAll();
		model.addAttribute("list", emps);
		return "display"; //jsp page
	}

}
