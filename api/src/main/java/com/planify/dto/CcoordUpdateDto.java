package com.planify.dto;

import java.util.Date;

import com.planify.model.Course;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class CcoordUpdateDto {
	
	private String firstName;
	private String lastName;
	private String mobilenumber;
	private String email;
	private Date dob;
	private String Specialization;
	private Course course;

}
