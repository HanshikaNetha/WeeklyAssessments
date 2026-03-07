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
public class CourseResponse {
    private Long courseId;
    private String title;
    private String description;
    private double price;
    private int duration;
    private String level;
    private String instructorName;
    private LocalDate createdAt;
}
