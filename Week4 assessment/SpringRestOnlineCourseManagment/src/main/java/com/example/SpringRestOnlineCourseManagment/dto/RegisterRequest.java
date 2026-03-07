package com.example.SpringRestOnlineCourseManagment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "shouldnt be blank")
    private String fullName;
    @NotBlank(message = "shouldnt be blank")
    private String email;
    @NotEmpty(message = "shouldnt be empty")
    private String password;
    private String role;
    private MultipartFile photo;
}
