package com.example.SpringRestOnlineCourseManagment.service;

import com.example.SpringRestOnlineCourseManagment.dto.LoginRequest;
import com.example.SpringRestOnlineCourseManagment.dto.RegisterRequest;
import com.example.SpringRestOnlineCourseManagment.dto.UserResponse;
import com.example.SpringRestOnlineCourseManagment.entity.User;
import com.example.SpringRestOnlineCourseManagment.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserResponse registerUser(RegisterRequest registerRequest, MultipartFile photo)throws IOException {
        User user=modelMapper.map(registerRequest, User.class);
        user.setProfilePicture(photo.getBytes());
        User savedUser=userRepository.save(user);
        UserResponse userResponse=modelMapper.map(savedUser, UserResponse.class);
        return userResponse;
    }

    public String loginUser(LoginRequest loginRequest){
        User user=userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(()->new RuntimeException("email not found pls register before login"));
        if(!user.getEmail().equals(loginRequest.getEmail())){
            throw new RuntimeException("Invalid password");
        }
        return "Login successful";
    }

    public byte[] photo(Long id){
        User user=userRepository.findById(id).orElseThrow(()->new RuntimeException("Id not found"));
        return user.getProfilePicture();
    }

    public UserResponse FetchUserProfile(Long id){
        User user=userRepository.findById(id).orElseThrow(()->new RuntimeException("user id not found"));
        UserResponse userResponse=modelMapper.map(user, UserResponse.class);
        userResponse.setProfilePicture("/users/"+user.getUserId()+"/photo");
        return userResponse;
    }
}
