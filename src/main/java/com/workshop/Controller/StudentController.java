package com.workshop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.workshop.Entity.Student;
import com.workshop.Service.Serviceimpl;

@Controller
public class StudentController {
	@Autowired
	Serviceimpl  service;
	
	
	@GetMapping("/")
	public String showHome(Model model) {
		model.addAttribute("student", service.getAllStudent());
			return "home";
	}
	
	
	@GetMapping("/add")
	public String showAdd(Model model) {
		Student student = new Student();
		model.addAttribute("student",student);
		return "Add";
	}
	
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student student) {
		service.save(student);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		service.deleteStudentById(id);
		return "redirect:/";
		
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id,Model model) {
		model.addAttribute("student", service.getStudentById(id));
		return "Edit";
	}
	
	@PostMapping("/{id}")
	public String update(@PathVariable Long id,@ModelAttribute("student") Student student, Model model) {
		Student s = service.getStudentById(id);
		s.setId(id);
		s.setFirstName(student.getFirstName());
		s.setLastName(student.getLastName());
		s.setEmail(student.getEmail());
		service.updateStudent(s);
		return "redirect:/";
	}
	
	
	

}
