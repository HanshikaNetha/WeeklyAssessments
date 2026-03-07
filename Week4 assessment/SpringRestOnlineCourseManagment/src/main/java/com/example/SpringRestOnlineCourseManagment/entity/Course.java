package com.example.SpringRestOnlineCourseManagment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private String title;
    private String description;
    private double price;
    private int duration;
    private String level;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    @ManyToOne
    private User instructor;
    @OneToMany(mappedBy = "course" )
    private List<Enrollment> enrollments;
    @OneToMany(mappedBy = "course")
    private List<CourseMaterial> courseMaterials;

}
