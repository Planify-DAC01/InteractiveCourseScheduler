package com.planify.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ccoord {

	@Id
	@SequenceGenerator(name="INSTRUCTOR_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INSTRUCTOR_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private Long id;
	
	
	
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(nullable = false)
	private Date dob;
	
	@OneToOne(mappedBy = "Ccord",cascade = CascadeType.ALL)
	private User user;
	
	
	private String Specialization;
	
	
	@ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
	
	
	
	
	
	
	
	
	
	
}
