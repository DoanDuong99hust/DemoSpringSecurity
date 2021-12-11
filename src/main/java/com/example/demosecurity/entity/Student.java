package com.example.demosecurity.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Integer studentId;

    private final String studentName;

    public Student(Integer studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }
}
