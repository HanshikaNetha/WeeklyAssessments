package com.example.SpringRestOnlineCourseManagment.controller;

import com.example.SpringRestOnlineCourseManagment.dto.LoginRequest;
import com.example.SpringRestOnlineCourseManagment.dto.RegisterRequest;
import com.example.SpringRestOnlineCourseManagment.dto.UserResponse;
import com.example.SpringRestOnlineCourseManagment.entity.User;
import com.example.SpringRestOnlineCourseManagment.repository.UserRepository;
import com.example.SpringRestOnlineCourseManagment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @PostMapping(value = "/register",  consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> register(@ModelAttribute RegisterRequest registerRequest)throws IOException {
        UserResponse response=userService.registerUser(registerRequest, registerRequest.getPhoto());
        return ResponseEntity.ok(response.getFullName()+"is sucesssfully registerd");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
        String out=userService.loginUser(loginRequest);
        return ResponseEntity.ok(out);
    }

    @GetMapping("/{id}/photo")
    public ResponseEntity<ByteArrayResource> photo(@PathVariable("id") Long id){
        ByteArrayResource resource=new ByteArrayResource(userService.photo(id));
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(resource);
    }

    @GetMapping("fetchUserDetails/{id}")
    public ResponseEntity<UserResponse> fetchUSerDetails(@PathVariable Long id){
        UserResponse response=userService.FetchUserProfile(id);
        return ResponseEntity.ok(response);
    }
}
