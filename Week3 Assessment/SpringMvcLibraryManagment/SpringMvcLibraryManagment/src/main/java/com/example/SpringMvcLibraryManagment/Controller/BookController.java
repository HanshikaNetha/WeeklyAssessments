package com.example.SpringMvcLibraryManagment.Controller;

import com.example.SpringMvcLibraryManagment.Model.Book;
import com.example.SpringMvcLibraryManagment.Service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {
    private BookService bookService;
    @Autowired
    public BookController(BookService bookService){
        this.bookService=bookService;
    }
    @GetMapping("/add")
    public String showAddBook(Model model){
        model.addAttribute("book", new Book());
        return "add-book";
    }
    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult result){
        if(result.hasErrors()){
            return "add-book";
        }
        bookService.addBook(book);
        return "redirect:/books/view";
    }
    @GetMapping("/view")
    public String viewBooks(Model model){
        model.addAttribute("books", bookService.getAllBooks());
        return "view-books";
    }
    @GetMapping("/{id}")
    public String viewBookById(@PathVariable("id") Long id, Model model){
        model.addAttribute("book", bookService.getBookById(id));
        return "book-details";
    }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id ){
        bookService.deleteById(id);;
        return "redirect:/books/view";
    }
}
