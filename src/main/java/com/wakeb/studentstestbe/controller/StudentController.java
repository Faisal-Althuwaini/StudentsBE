package com.wakeb.studentstestbe.controller;

import com.wakeb.studentstestbe.entity.Student;
import com.wakeb.studentstestbe.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class StudentController {
    @Autowired
    StudentService  studentService;
    @GetMapping()
    public List<Student> findAll() {
        return studentService.findAll();
    }
}
