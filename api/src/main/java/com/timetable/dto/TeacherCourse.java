package com.timetable.dto;

import com.timetable.entity.Batch;
import com.timetable.entity.Course;
import com.timetable.entity.User;

public class TeacherCourse {

	private Course course;

	private User teacher;

	private Batch batch;   // only for timetable by teacher

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public User getTeacher() {
		return teacher;
	}

	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

}
