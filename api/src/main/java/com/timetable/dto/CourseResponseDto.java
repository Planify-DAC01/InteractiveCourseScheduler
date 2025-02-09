package com.timetable.dto;

import java.util.ArrayList;
import java.util.List;

import com.timetable.entity.Course;

public class CourseResponseDto extends CommonApiResponse {

	private List<Course> courses = new ArrayList<>();

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}
