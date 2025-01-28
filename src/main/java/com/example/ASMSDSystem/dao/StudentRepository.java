package com.example.ASMSDSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ASMSDSystem.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
