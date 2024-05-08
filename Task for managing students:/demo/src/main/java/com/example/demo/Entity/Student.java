package com.example.demo.Entity;

import jakarta.persistence.*;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

@Data
@Entity
@Table(name = "student")
public class Student {
    //Create a `Student` class with attributes like `id`, `name`, `age`, `grade`, etc.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer age;
    private Long grade;
}