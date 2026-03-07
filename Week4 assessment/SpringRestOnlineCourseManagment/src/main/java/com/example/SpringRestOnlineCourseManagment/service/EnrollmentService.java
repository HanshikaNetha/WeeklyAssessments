package com.example.SpringRestOnlineCourseManagment.service;

import com.example.SpringRestOnlineCourseManagment.dto.EnrollmentRequest;
import com.example.SpringRestOnlineCourseManagment.dto.EnrollmentResponse;
import com.example.SpringRestOnlineCourseManagment.entity.Course;
import com.example.SpringRestOnlineCourseManagment.entity.Enrollment;
import com.example.SpringRestOnlineCourseManagment.entity.EnrollmentStatus;
import com.example.SpringRestOnlineCourseManagment.entity.User;
import com.example.SpringRestOnlineCourseManagment.repository.CourseRepository;
import com.example.SpringRestOnlineCourseManagment.repository.EnrollmentRepository;
import com.example.SpringRestOnlineCourseManagment.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    public EnrollmentResponse addEnrollemnt(EnrollmentRequest enrollmentRequest){
        User student=userRepository.findById(enrollmentRequest.getUserId()).orElseThrow(()->new RuntimeException("student id not found"));
        Course course=courseRepository.findById(enrollmentRequest.getCourseId()).orElseThrow(()->new RuntimeException("course id not found"));
        Enrollment enrollment=new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollmentDate(LocalDate.now());
        enrollment.setStatus(EnrollmentStatus.ACTIVE);
        enrollment.setProgressPercentage(0);
        Enrollment saveEnrollement=enrollmentRepository.save(enrollment);
        EnrollmentResponse enrollmentResponse=modelMapper.map(saveEnrollement, EnrollmentResponse.class);
        return enrollmentResponse;
    }

    public EnrollmentResponse getEnrollmentByStudentId(Long id){
        Enrollment enrollment=enrollmentRepository.findByStudentUserId(id).orElseThrow(()->new RuntimeException("student not found"));
        EnrollmentResponse enrollmentResponse=modelMapper.map(enrollment, EnrollmentResponse.class);
        return enrollmentResponse;
    }

    public EnrollmentResponse getEnrollmentByCourse(Long id){
        Enrollment enrollment=enrollmentRepository.findByCourseCourseId(id).orElseThrow(()->new RuntimeException("course not found"));
        EnrollmentResponse enrollmentResponse=modelMapper.map(enrollment, EnrollmentResponse.class);
        return enrollmentResponse;
    }
};
