package com.project.coaching.center.repository;

import com.project.coaching.center.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    boolean existsByCourseId(Long courseId);

    boolean existsByEmail(String email);


    List<Student> findByCourseId(Long courseId);

    List<Student> findByStudentNameContainingIgnoreCase(String studentName);
}