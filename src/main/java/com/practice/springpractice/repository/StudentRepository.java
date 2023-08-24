package com.practice.springpractice.repository;

import com.practice.springpractice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Modifying
    @Query("UPDATE Student s SET s.points = s.points + 1 WHERE s.name = ?1")
    void incrementStudentPoints(String studentName);
}
