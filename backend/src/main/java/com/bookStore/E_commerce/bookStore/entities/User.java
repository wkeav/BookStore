package com.bookStore.E_commerce.bookStore.entities;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bookStore.E_commerce.bookStore.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
/*
 * This entity 
 */
@Entity
@Data //lombok auto create getter/setter 
@Table(name = "users")
public class User implements UserDetails { //UserDetails is from spring security, provide all necessary user authentication
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY ) //auto generate ID values 
    private Long id; 

    @Column(name="email", nullable=false, unique=true)
    private String email;

    @Column(name="password", nullable=false)
    private String password;

    @Column(name="name", nullable=false)
    private String name; 

    @Enumerated(EnumType.STRING)
    private Role role = Role.CUSTOMER; //default role is customer 

    private boolean enabled = true;

    //Spring Security uses these authorities to check if the user has access to 
    //certain parts of the application based on roles.
    @Override
    public Collection <? extends GrantedAuthority > getAuthorities(){
        //CUSTOMER = ROLE_CUSTOMER  
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

    @Override
    public String getUsername(){
        return email; //email is our username in this case 
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;  
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled; //return the enabled status 
    }

}
