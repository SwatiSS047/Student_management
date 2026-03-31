package com.simple.Student_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}

}
//Why this step is required?
//@SpringBootApplication = tells Spring:
//Start application
//Scan components
//Auto-configure everything
//
//👉 This is the entry point of your app