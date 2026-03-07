package com.example.SpringRestOnlineCourseManagment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentResponse {
    private Long enrollmentId;
    private String courseTitle;
    private String fullName;
    private String status;
    private int progressPercentage;
    private LocalDate enrollmentDate;
}
