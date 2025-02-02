package com.planify.service;

import com.planify.model.Course;
import com.planify.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Get all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Get a course by ID
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    // Add a new course
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    // Update an existing course
    public Course updateCourse(Long id, Course courseDetails) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));

        course.setCourseName(courseDetails.getCourseName());
        course.setDescription(courseDetails.getDescription());
        course.setInstructor(courseDetails.getInstructor());
        course.setCode(courseDetails.getCode());

        return courseRepository.save(course);
    }

    // Delete a course
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
