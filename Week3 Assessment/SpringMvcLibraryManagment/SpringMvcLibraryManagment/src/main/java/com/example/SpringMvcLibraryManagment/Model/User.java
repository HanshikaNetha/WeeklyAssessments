package com.example.SpringMvcLibraryManagment.Model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;


public class User {
    private Long id;
    @NotBlank(message = "name must not be null")
    @Size(min = 3, message = "names must have atleast 3 characters")
    private String name;
    @Email(message = "email is not in the correct format")
    private String email;
    @Size(min=6, message = "password must have atkeast 6 charcters")
    private String password;

    public User(){

    }
    public User(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
