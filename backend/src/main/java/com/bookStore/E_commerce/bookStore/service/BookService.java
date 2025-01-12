package com.bookStore.E_commerce.bookStore.service;

import com.bookStore.E_commerce.bookStore.entities.Book;
import com.bookStore.E_commerce.bookStore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository; 

    //get all books from database 
    public List<Book> getAllBooks(){
        return this.bookRepository.findAll();
    }

    //get book by a specific id from database 
    public Book getBookById(Long id){
        return this.bookRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Book is not found!"));
    }

    //create new book to the database 
    public Book createBook(Book book){
        return this.bookRepository.save(book);
    }

}
