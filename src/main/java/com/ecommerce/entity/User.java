package com.ecommerce.entity;

import org.springframework.cglib.core.Local;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.annotation.Generated;
import jakarta.persistence.Access;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;  

@Entity
@Table(name = "users")
public class User implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank (message = "Username is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    @Column (unique = true, nullable = false)
    private String username;

    @NotBlank (message = "Email is required")
    @Email(message = "Email should be valid")
    @Column (unique = true, nullable = false)  
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    @Column(nullable = false)
    private String password;

    @NotBlank (message = "First name is required")
    @Column (name = "first_name", nullable = false)  
    private String firstname;
 
    @NotBlank (message = "Last name is required")
    @Column (name = "last_name", nullable = false)  
    private String lastname;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "created_at",  nullable = false, updatable = false)
    private Local  date createdAt;

    private Role role = Role.USER;

    public enum role{
        user;
        admin;
    }
}

