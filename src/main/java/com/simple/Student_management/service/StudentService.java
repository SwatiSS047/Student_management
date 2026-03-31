package com.simple.Student_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.Student_management.entity.Student;
import com.simple.Student_management.exception.StudentNotFoundException;
import com.simple.Student_management.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getAllStudents(){		// to get all students
		return studentRepository.findAll();
	}
	
	public List<Student> saveAll(List<Student> students) {
		return studentRepository.saveAll(students);
	}
	
	public Student getStudentById(Long id) {		// to get single / one / individual student
		return studentRepository.findById(id)
	            .orElseThrow(() -> new StudentNotFoundException(
	                "No data exists, out of number of students"
	            ));
	}
	
	public Student saveStudent(Student student) {		// to save all students
		return studentRepository.save(student);
	}
	
	public Student updateStudent(Long id, Student newStudent) {		// to edit or update the data of the student
		Student existing = studentRepository.findById(id).orElse(null);
		
		if(existing != null) {
			existing.setName(newStudent.getName());
			existing.setEmail(newStudent.getEmail());
			existing.setCourse(newStudent.getCourse());
			
			return studentRepository.save(existing);
		}
		return null;
	}
	
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}
//
//	public long getStudentCount() {
//		return studentRepository.count();
//	}
//	
	
	
}
//❓ Why this step is required?
//Service = business logic layer
//Keeps controller clean
//
//👉 Without service:
//Controller becomes messy and hard to maintain