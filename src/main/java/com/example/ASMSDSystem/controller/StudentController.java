package com.example.ASMSDSystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ASMSDSystem.model.Student;
import com.example.ASMSDSystem.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentService service;
	
	@PostMapping
	public String addStudent(@RequestBody Student student)
	{
		service.addStudent(student);
		return "Student Added...";
		
	}
	
	@GetMapping
	List<Student> getAll()
	{
		return service.getAll();
		
	}
	@DeleteMapping("/{id}")
	String deleteStudentById(@PathVariable int id)
	{
		service.deleteStudent(id);
		return "Student Deleted..";
	}
	
	@PutMapping("/{id}")
	String updateStudent(@PathVariable int id, @RequestBody Student student)
	{
		service.updateStudent(id,student);
		return "Student Updated";
		
	}
	@GetMapping("/{id}")
	Optional<Student> getById(@PathVariable int id)
	{
		
		return service.getById(id);
	}
	
	
}
