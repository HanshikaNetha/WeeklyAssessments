package com.example.SpringRestOnlineCourseManagment.dto;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequest {
    private String title;
    private String description;
    @Positive(message = "price should be greater than 0")
    private double price;
    @Positive(message = "duration shoudl be greater than 0")
    private int duration;
    private String level;
}
