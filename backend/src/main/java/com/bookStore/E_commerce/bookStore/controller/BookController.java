package com.bookStore.E_commerce.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookStore.E_commerce.bookStore.service.BookService;
import com.bookStore.E_commerce.bookStore.entities.Book;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins =  "http://localhost:3000") //for React frontend 
public class BookController {
    
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks(){
        return this.bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){
        return this.bookService.getBookById(id);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book){
        return this.bookService.createBook(book);
    }
    
}
