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
    @GeneratedValue(strategy=GenerationType.IDENTITY )
    private Long id; 

    @Column(name="book")
    private String book;

    @Column(name="author")
    private String author;

    @Column(name="isbn", unique=true)
    private String isbn;

    @Column(name="price")
    private Double price;

    private String description;

}
