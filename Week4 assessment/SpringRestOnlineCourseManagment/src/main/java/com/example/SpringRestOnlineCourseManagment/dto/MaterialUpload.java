package com.example.SpringRestOnlineCourseManagment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MaterialUpload {
    private String title;
    private Long courseId;
    private String fileName;
}
