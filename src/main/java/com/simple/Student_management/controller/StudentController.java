package com.simple.Student_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.Student_management.entity.Student;
import com.simple.Student_management.repository.StudentRepository;
import com.simple.Student_management.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
    private StudentRepository studentRepository;
	
	@Autowired
	private StudentService studentService;

    StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
	
	@GetMapping 				//get all
	public List<Student> getStudents(){
		return studentService.getAllStudents();
	}
	@PostMapping("/bulk")
	public String addStudents(@RequestBody List<Student> students){
		int count = studentService.saveAll(students).size();
		return count + " students data is added successfully";
	}
	
	@GetMapping("/{id}")		//get by id
	public ResponseEntity<Student> getStudent(@PathVariable Long id) {
		return ResponseEntity.ok(studentService.getStudentById(id));
	}
	
	@PostMapping				//create
	public Student addstudent(@Valid @RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	@PutMapping("/{id}")		//update
	public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
		return studentService.updateStudent(id, student);
	}
	
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return "Student Details Deleted successfully";
	}
	
	@GetMapping("/count")
	public long getCount() {
	    return studentRepository.count();
	}
	
	@GetMapping("/email/{email}")
	public Student getByEmail(@PathVariable String email) {
	    return studentService.getByEmail(email);
	}
}
//❓ Why this step is required?
//Controller = handles HTTP requests
//Converts JSON → Java object
//
//👉 This is what users (frontend/Postman) interact with