package com.planify.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Column;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String mobilenumber;

    @Email
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)

    private String password;

    private String category; // "Student", "Coordinator", "Faculty"

    @Override
    public String toString() {
        return "User [category=" + category + ", email=" + email + ", firstname=" + firstname + ", id=" + id
                + ", lastname=" + lastname + ", mobilenumber=" + mobilenumber + ", password=" + password + "]";
    }
}