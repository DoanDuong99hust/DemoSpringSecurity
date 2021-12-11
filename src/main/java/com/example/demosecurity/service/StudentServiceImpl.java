package com.example.demosecurity.service;

import com.example.demosecurity.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Override
    public List<Student> findAll() {
        return null;
    }
}
