package com.planify.model;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.List;



import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

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
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ccid",referencedColumnName = "id" )
    private Ccoord Ccoord ;
    
    @ManyToOne
	@JoinColumn(name="department_id")
	private Course course;
    
    
    
    
    
    
    
    
    
    

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }
    
    @Override
    public String toString() {
        return "User [category=" + category + ", email=" + email + ", firstname=" + firstname + ", id=" + id
                + ", lastname=" + lastname + ", mobilenumber=" + mobilenumber + ", password=" + password + "]";
    }

    @Override
    public String getUsername() {
        return email;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
}