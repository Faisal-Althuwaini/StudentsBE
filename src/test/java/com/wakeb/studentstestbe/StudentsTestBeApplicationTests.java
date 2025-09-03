package com.wakeb.studentstestbe;

import com.wakeb.studentstestbe.controller.StudentController;
import com.wakeb.studentstestbe.entity.Student;
import com.wakeb.studentstestbe.repos.StudentRepo;
import com.wakeb.studentstestbe.services.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class StudentsTestBeApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    StudentController studentController;

    @Autowired
    StudentService studentService;

    @Autowired
    StudentRepo  studentRepo;

    @Test
    public void testFindByIdService() {
        Optional<Student> expected = studentRepo.findById(25);
        Optional<Student> actual = studentService.findById(25);

        assertTrue(expected.isPresent(), "Expected student not found in repo.");
        assertTrue(actual.isPresent(), "Expected student not found in service.");

        assertEquals(expected.get(), actual.get());
    }

    @Test
    public void testFindAllService() {
        List<Student> expected = studentRepo.findAll();
        List<Student> actual = studentService.findAll();

        assertEquals(expected.size(), actual.size());
    }

    @Test
    public void testFindAllController() {
        List<Student> expected = studentRepo.findAll();
        List<Student> actual = studentController.findAll();

        assertEquals(expected.size(), actual.size());
    }

    @Test
    public void testFindAllEndpoint() {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8081";
        List<Student> students = restTemplate.getForObject(url, List.class);
        int size = students.size();
        assertTrue(size > 0,"Error in students array size");
    }


}
