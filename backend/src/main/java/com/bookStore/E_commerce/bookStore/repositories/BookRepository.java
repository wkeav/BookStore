package com.bookStore.E_commerce.bookStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bookStore.E_commerce.bookStore.entities.Book;

public interface BookRepository extends JpaRepository<Book,Long>{
    // Spring Data JPA will automatically implement basic CRUD operations
}
