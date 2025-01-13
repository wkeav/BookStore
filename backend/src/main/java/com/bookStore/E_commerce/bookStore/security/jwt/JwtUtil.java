package com.bookStore.E_commerce.bookStore.security.jwt;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.security.Keys;

/*
 * 
 */
@Component //make this class a spring managed bean
public class JwtUtil {
    @Value("${jwt.secret}") //read from application.properties 
    private String secret;  

    @Value("${jwt.expiration}")
    private Long expiration; //expire time in milliseconds 

    //retrieving the secret key 
    private Key getSigningKey(){
        byte[] keyBytes = secret.getBytes(); //cryptographic signing operation , has to be bytes
        return Keys.hmacShaKeyFor(keyBytes);
    }

    //generate new JWT for user
    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims = new HashMap<>();
        return createToken(claims,userDetails.getUsername());
    }

    
}
