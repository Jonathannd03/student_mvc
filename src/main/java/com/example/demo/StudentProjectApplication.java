package com.example.demo;

import com.example.demo.student.model.Student;
import com.example.demo.student.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.time.Month;

@SpringBootApplication
public class StudentProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(StudentProjectApplication.class, args);

	}

}
