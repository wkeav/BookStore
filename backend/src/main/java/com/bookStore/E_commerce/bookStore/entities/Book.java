package com.bookStore.E_commerce.bookStore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data // lombok will have automatic getter & setters
@Table(name="books")
public class Book {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY ) //auto generate ID values 
    private Long id; 

    @Column(name="book",nullable=false)
    private String book;

    @Column(name="author",nullable=false)
    private String author;

    @Column(name="isbn", unique=true,nullable=false) //isbn has to be unique for each book
    private String isbn;

    @Column(name="price", nullable=false)
    private Double price;

    @Column(length=1000)
    private String description;

}
