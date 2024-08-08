package com.example.demo.student;

import com.example.demo.student.model.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(Integer id){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.orElse(null);
    }

    public Student saveStudent (Student student){
        log.info("Employee with id: {} saved successfully", student.getId());
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student){
        Optional<Student> existingStudentOpt = studentRepository.findById(student.getId());
        if(existingStudentOpt.isPresent()){
            Student existingStudent = existingStudentOpt.get();
            existingStudent.setName(student.getName());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setDob(student.getDob());
            existingStudent.setAge(student.getAge());

            return studentRepository.save(existingStudent);
        } else {
            log.error("Student with id {} not found", student.getId());
            return null;
        }
    }

    public void deleteStudentById(Integer id){
        studentRepository.deleteById(id);
    }
}
