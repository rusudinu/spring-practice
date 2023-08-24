package com.practice.springpractice.service;

import com.practice.springpractice.model.Student;
import com.practice.springpractice.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student getStudent() {
        List<Student> studentList = studentRepository.findAll();
        List<Student> biasedStudentList = new ArrayList<>();

        for(Student student : studentList) {
            for(int i = 0; i < student.computeBias(); i++) {
                biasedStudentList.add(student);
            }
        }

        Collections.shuffle(biasedStudentList);

        return biasedStudentList.get(0);
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    public void incrementPoints(String studentName) {
        studentRepository.incrementStudentPoints(studentName);
    }

    @Transactional
    public void decrementPoints(String studentName) {
        studentRepository.decrementStudentPoints(studentName);
    }
}
