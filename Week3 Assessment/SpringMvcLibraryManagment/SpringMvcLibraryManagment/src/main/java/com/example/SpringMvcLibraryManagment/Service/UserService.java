package com.example.SpringMvcLibraryManagment.Service;

import com.example.SpringMvcLibraryManagment.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> users=new ArrayList<>();
    public void registerUser(User user){
        users.add(user);
    }
    public boolean validateUser(String email, String password){
        return users.stream().anyMatch(i->i.getEmail().equals(email) && i.getPassword().equals(password));
    }
}
