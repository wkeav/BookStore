package com.bookStore.E_commerce.bookStore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
 * seeing back the token to the client after successful login/register 
 * ensure that no password or sensitive data is send back 
 */
@Data
@AllArgsConstructor 
public class AuthResponse {
    private String token;
}
