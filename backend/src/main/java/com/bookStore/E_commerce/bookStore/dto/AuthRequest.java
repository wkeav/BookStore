package com.bookStore.E_commerce.bookStore.dto;

import lombok.Data;

/*
 * This dto is used when user tries to login/register using their email & password 
 */
@Data
public class AuthRequest {
    private String email;
    private String password;
}
