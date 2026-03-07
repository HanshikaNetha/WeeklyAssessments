package com.example.SpringRestOnlineCourseManagment.repository;

import com.example.SpringRestOnlineCourseManagment.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    public Optional<Enrollment> findByCourseCourseId(Long courseId);
    public Optional<Enrollment> findByStudentUserId(Long StudentID);
}
