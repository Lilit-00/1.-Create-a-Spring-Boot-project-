package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/students")
public class StudentConttroler{

    @Autowired
    private StudentService studentSrvice;

    // Endpoint to retrieve all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentSrvice.getAllStudents();
    }

    // Endpoint to retrieve a student by id
    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return studentSrvice.getStudentById(id);
    }

    // Endpoint to create a new student
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentSrvice.saveOrUpdateStudent(student);
    }

    // Endpoint to update an existing student
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id); // Set the id of the student object to update
        return studentSrvice.saveOrUpdateStudent(student);
    }

    // Endpoint to delete a student by id
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentSrvice.deleteStudentById(id);
    }
}
