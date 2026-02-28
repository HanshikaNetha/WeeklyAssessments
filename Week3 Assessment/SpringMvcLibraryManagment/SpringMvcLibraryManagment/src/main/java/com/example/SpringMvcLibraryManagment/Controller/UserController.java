package com.example.SpringMvcLibraryManagment.Controller;


import com.example.SpringMvcLibraryManagment.Model.User;
import com.example.SpringMvcLibraryManagment.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service){
        this.service=service;
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model){
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result){
        if(result.hasErrors()){
            return "register";
        }
        service.registerUser(user);
        return "redirect:/user/login";
    }
    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }
    @PostMapping("/login")
    public String login(@RequestParam("email") String email,@RequestParam("password") String password , Model model){
        if(service.validateUser(email, password)){
            return "redirect:/user/dashboard";
        }
        model.addAttribute("error", "Invalid credintials");
        return "login";
    }
    @GetMapping("/dashboard")
    public String showDashBoard(){
        return "dashboard";
    }



}
