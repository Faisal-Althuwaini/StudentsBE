package com.wakeb.studentstestbe.services;

import com.wakeb.studentstestbe.entity.Student;
import com.wakeb.studentstestbe.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    public Optional<Student> findById(Integer id) {
       return studentRepo.findById(id);
    };

    public List<Student> findAll() {
        return studentRepo.findAll();
    }

}
