package com.example.ASMSDSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.ASMSDSystem.dao.StudentRepository;
import com.example.ASMSDSystem.model.Student;

@Service
public class StudentService {

	
	@Autowired
	StudentRepository re;
	
	public void addStudent(Student student) {
		re.save(student);
		
	}

	public List<Student> getAll() {
	
		return re.findAll();
	}

	public void deleteStudent(int id) {
		Optional<Student>student= re.findById(id);
		
		student.ifPresent(re::delete);
	}

	public void updateStudent(int id, Student student) {
Optional<Student>student1= re.findById(id);
		
		boolean present =student1.isPresent();
		if(present)
		{
			Student s1=student1.get();
			s1.setEmail(student.getEmail());
			s1.setName(student.getName());
			re.save(s1);
		}
		
	}

	public Optional<Student> getById(int id) {
		
		return re.findById(id);
		
	}

}
