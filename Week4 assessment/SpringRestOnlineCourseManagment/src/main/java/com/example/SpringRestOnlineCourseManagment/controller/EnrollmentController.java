package com.example.SpringRestOnlineCourseManagment.controller;

import com.example.SpringRestOnlineCourseManagment.dto.EnrollmentRequest;
import com.example.SpringRestOnlineCourseManagment.dto.EnrollmentResponse;
import com.example.SpringRestOnlineCourseManagment.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/enrollments")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @PostMapping("/addEnrollments")
    public ResponseEntity<String> Enrolleing(@RequestBody EnrollmentRequest enrollmentRequest){
        EnrollmentResponse enrollmentResponse=enrollmentService.addEnrollemnt(enrollmentRequest);
        return ResponseEntity.ok(enrollmentResponse.getFullName()+" is enrolled in "+enrollmentResponse.getCourseTitle());
    }

    @GetMapping("/getEnrollment/student/{id}")
    public ResponseEntity<EnrollmentResponse> getEnrollmentByStudent(@PathVariable("id") Long id){
        EnrollmentResponse enrollmentResponse=enrollmentService.getEnrollmentByStudentId(id);
        return ResponseEntity.ok(enrollmentResponse);
    }

    @GetMapping("/getEnrollment/course/{id}")
    public ResponseEntity<EnrollmentResponse> getEnrollmentByCourse(@PathVariable("id") Long id){
        EnrollmentResponse enrollmentResponse=enrollmentService.getEnrollmentByCourse(id);
        return ResponseEntity.ok(enrollmentResponse);
    }
}
