package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


import java.util.Optional;


@RestController
@RequestMapping("/api/students")
public class StudentService{
    @Autowired
    private StudentRepository studentRepository;


    public List<Student> getAllStudents(){
        return studentRepository.findAll();

    }
    public Optional<Student> getStudentById(Long id){
        return studentRepository.findById(id);

    }
    public Student saveOrUpdateStudent(Student student){
        return studentRepository.save(student);
    }
    public void deleteStudentById(Long id){
        studentRepository.deleteById(id);

    }
}
