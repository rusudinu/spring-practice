package com.practice.springpractice.controller;

import com.practice.springpractice.model.Student;
import com.practice.springpractice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/students")
public class StudentController {
    public final StudentService studentService;

    @GetMapping
    public Student getStudent() {
        return studentService.getStudent();
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PostMapping("increment")
    public void incrementStudentPoints(@RequestBody Student student) {
        studentService.incrementPoints(student.getName());
    }
}
