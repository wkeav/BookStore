package com.bookStore.E_commerce.bookStore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.E_commerce.bookStore.entities.User;
import com.bookStore.E_commerce.bookStore.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository; 

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository; 
    }

    //find user email
    public Optional <User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
