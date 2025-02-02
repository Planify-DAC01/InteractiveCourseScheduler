package com.planify.controller.cource;

import com.planify.model.Course;
import com.planify.model.Response;
import com.planify.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    // Get all courses
    @GetMapping("/courses")
    public ResponseEntity<Response> getAllCourses() {
        Response successResponse = new Response(
            HttpStatus.OK.value(),
            "success",
            courseService.getAllCourses() );
         return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }

    // Get a course by ID
    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Add a new course
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    // Update an existing course
    @PutMapping("/courses/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course courseDetails) {
        return ResponseEntity.ok(courseService.updateCourse(id, courseDetails));
    }

    // Delete a course
    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Response> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        Response successResponse = new Response(
            HttpStatus.OK.value(),
            "Deleted");
         return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }
}