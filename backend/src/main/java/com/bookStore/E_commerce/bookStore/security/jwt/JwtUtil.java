package com.bookStore.E_commerce.bookStore.security.jwt;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;


/* 
 * The security guard part of JSON Web Token:
 *  - creating the token (header,payload, signature)
 *  - ensure its valid, verify the token 
 *  - read information from the token 
 */
@Component //make this class a spring managed bean
public class JwtUtil {
    @Value("${jwt.secret}") //read from application.properties 
    private String secret;  

    @Value("${jwt.expiration}")
    private Long expiration; //expire time in milliseconds 

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    //check to see if token is expire 
    private boolean isTokenExpired(String token) {
        Date expiration = Jwts.parserBuilder()
        .setSigningKey(secret.getBytes())
        .build()
        .parseClaimsJws(token)
        .getBody()
        .getExpiration();
        return expiration.before(new Date());
    }

    //generate token when user logs in
    public String generateToken(UserDetails userDetails){
        return Jwts.builder()
            .setSubject(userDetails.getUsername())      //store email in token
            .setIssuedAt(new Date())                    // when token was created
            .setExpiration(new Date(System.currentTimeMillis() + expiration))
            .signWith(getSigningKey(),SignatureAlgorithm.HS256)
            .compact();
    }

    public String getEmailFromToken(String token){
        return Jwts.parserBuilder()                    //Step 1: Create a JWT parser
            .setSigningKey(secret.getBytes())         //Step 2: Set the secret key used to sign the JWT
            .build()
            .parseClaimsJws(token)                    //Step 3: Parse and verify the JWT
            .getBody()                                //Step 4: Retrieve the body (claims) of the JWT
            .getSubject();                            //Step 5: Get the 'subject' claim (email in this case)
}

    //check if token is valid
    public  Boolean validateToken(String token, UserDetails userDetails){
        try{
            String email = getEmailFromToken(token);
            return email.equals(userDetails.getUsername()) && !isTokenExpired(token);   //valid if email is correct provided email and token isn't expired
        } catch(Exception e){
            return false;
        }
    }
}
