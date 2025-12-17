package com.ecommerce.entity;

import java.time.LocalDateTime;

import org.springframework.cglib.core.Local;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.annotation.Generated;
import jakarta.persistence.Access;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;  
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;  

@Entity
@Table(name = "users")
public class User {

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
    private String firstName;
 
    @NotBlank (message = "Last name is required")
    @Column (name = "last_name", nullable = false)  
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "created_at",  nullable = false, updatable = false)
    private Local  date createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.USER;

    public User() {
        this.createdAt = new LocalDateTime();
        this.updatedAt = new LocalDateTime();
    }

    public User(String username, String email, String password, String firstname, String lastname) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastname = lastName;
        
    }           
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public enum role{
        USER,
        ADMIN  
    }
}

