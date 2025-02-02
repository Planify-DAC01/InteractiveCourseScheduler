package com.planify.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;
    private String description;
    private String instructor;
    private String code;
    
    @Override
    public String toString() {
        return "Course [id=" + id + ", courseName=" + courseName + ", description=" + description + ", instructor="
                + instructor + ", code=" + code + "]";
    }
    
}