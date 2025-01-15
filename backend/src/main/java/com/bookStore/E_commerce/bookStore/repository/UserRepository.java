package com.bookStore.E_commerce.bookStore.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bookStore.E_commerce.bookStore.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);
}
