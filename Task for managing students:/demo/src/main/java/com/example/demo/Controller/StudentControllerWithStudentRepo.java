package com.example.demo.Controller;

import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentControllerWithStudentRepo implements StudentRepo {


}
@Controller("/")
class Student_Controller {

    private final List<Student> students = new ArrayList<>();

    // CREATE operation
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

    // READ operation
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        Optional<Student> optionalStudent = students.stream().filter(s -> s.getId() == id).findFirst();
        return optionalStudent.orElse(null);
    }

    // UPDATE operation
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student studentDetails) {
        Optional<Student> optionalStudent = students.stream().filter(s -> s.getId() == id).findFirst();
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName(studentDetails.getName());
            student.setAge(studentDetails.getAge());
            // Update other fields as needed
            return student;
        } else {
            return null; // Or handle the case where student with given id is not found
        }
    }

    // DELETE operation
    @GetMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        Optional<Student> optionalStudent = students.stream().filter(s -> s.getId() == id).findFirst();
        if (optionalStudent.isPresent()) {
            students.remove(optionalStudent.get());
            return "Student with id " + id + " deleted successfully";
        } else {
            return "Student with id " + id + " not found";
        }
    }

    // READ operation (Get all students)
    @GetMapping
    public List<Student> getAllStudents() {
        return students;
    }
}