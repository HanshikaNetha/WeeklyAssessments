package com.example.SpringMvcLibraryManagment.Exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BookNotFoundException.class)
    public String handleBookNotFound(BookNotFoundException ex, Model model){
        model.addAttribute("errormessage", ex.getMessage());
        return "error";
    }
    @ExceptionHandler(Exception.class)
    public String handleAllException(Exception ex, Model model){
        model.addAttribute("errormessage", "something went wrong");
        return "error";
    }

}
