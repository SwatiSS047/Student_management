package com.simple.Student_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simple.Student_management.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
//Why this step is required?
//Repository = talks to DB
//JpaRepository gives:
//save()
//findAll()
//delete()
//findById()
//
//👉 You don’t write SQL manually 😎