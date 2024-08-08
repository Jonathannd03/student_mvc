package com.example.demo.student;

import com.example.demo.student.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/student/v1")
@RequiredArgsConstructor
@Validated
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent(){
        return ResponseEntity.ok().body(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id){
        return ResponseEntity.ok().body(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return ResponseEntity.ok().body(studentService.saveStudent(student));
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        return ResponseEntity.ok().body(studentService.updateStudent(student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id){
        studentService.deleteStudentById(id);
        return ResponseEntity.ok().body("Deleted successfully");
    }


}
