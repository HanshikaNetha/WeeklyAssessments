package com.example.SpringRestOnlineCourseManagment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="enrollments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long EnrollmentId;
    private LocalDate enrollmentDate;
    @Enumerated(EnumType.STRING)
    private EnrollmentStatus status;
    private int progressPercentage;
    @ManyToOne
    private User student;
    @ManyToOne
    private Course course;

}
