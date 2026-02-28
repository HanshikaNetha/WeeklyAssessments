package com.example.SpringMvcLibraryManagment.Service;

import com.example.SpringMvcLibraryManagment.Exception.BookNotFoundException;
import com.example.SpringMvcLibraryManagment.Model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<Book> books=new ArrayList<>();
    public void addBook(Book book){
        books.add(book);
    }
    public List<Book> getAllBooks(){
        return books;
    }
    public Book getBookById(Long id){
        return books.stream().filter(i->i.getId()==id).findFirst().orElseThrow(()->new BookNotFoundException("Book "+ id+" is not found"));
    }
    public void deleteById(Long id){
        Book book=getBookById(id);
        books.remove(book);
    }
}
