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
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String fullName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Lob
    private byte[] profilePicture;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    @OneToMany(mappedBy = "instructor")
    private List<Course> courses;
    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments;

}
