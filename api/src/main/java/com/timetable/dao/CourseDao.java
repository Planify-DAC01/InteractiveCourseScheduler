package com.timetable.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.timetable.entity.Course;
import com.timetable.entity.Grade;

@Repository
public interface CourseDao extends JpaRepository<Course, Integer> {
	
	List<Course> findByGradeAndStatus(Grade grade, String status);
	
	List<Course> findByStatus(String status);	
	boolean existsByNameAndStatus(String name,String status);	
	boolean existsByNameAndStatusAndGrade(String name, String status, Grade grade);									

}
