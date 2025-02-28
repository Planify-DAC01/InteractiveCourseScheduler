package com.timetable.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.timetable.dao.CourseDao;
import com.timetable.dto.AddCourseRequest;
import com.timetable.dto.CommonApiResponse;
import com.timetable.dto.CourseResponseDto;
import com.timetable.entity.Course;
import com.timetable.entity.Grade;
import com.timetable.exception.CourseSaveFailedException;
import com.timetable.exception.GradeSaveFailedException;
import com.timetable.service.CourseService;
import com.timetable.service.GradeService;
import com.timetable.utility.Constants.ActiveStatus;

import jakarta.transaction.Transactional;

@Component
@Transactional
public class CourseResource {

	private final Logger LOG = LoggerFactory.getLogger(CourseResource.class);

	@Autowired
	private CourseService courseService;

	@Autowired
	private CourseDao courseDao;

	@Autowired
	private GradeService gradeService;

	public ResponseEntity<CommonApiResponse> addCourse(AddCourseRequest request) {

		LOG.info("Request received for add course");

		CommonApiResponse response = new CommonApiResponse();

		if (request == null || !AddCourseRequest.validate(request)) {
			response.setResponseMessage("missing input");
			response.setSuccess(false);

			return new ResponseEntity<CommonApiResponse>(response, HttpStatus.BAD_REQUEST);
		}

		Grade grade = this.gradeService.getGradeById(request.getGradeId());

		if (grade == null) {
			response.setResponseMessage("grade not found");
			response.setSuccess(false);

			return new ResponseEntity<CommonApiResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (courseDao.existsByNameAndStatusAndGrade(request.getName(),"Active",grade)) {
			response.setResponseMessage("Course already exists");
			response.setSuccess(false);

			return new ResponseEntity<CommonApiResponse>(response, HttpStatus.BAD_REQUEST);
		}
		Course course = new Course();
		course.setName(request.getName());
		course.setDescription(request.getDescription());
		course.setGrade(grade);
		course.setStatus(ActiveStatus.ACTIVE.value());

		Course savedCourse = this.courseService.addCourse(course);

		if (savedCourse == null) {
			throw new CourseSaveFailedException("Failed to add course");
		}

		response.setResponseMessage("Course Added Successful");
		response.setSuccess(true);

		return new ResponseEntity<CommonApiResponse>(response, HttpStatus.OK);

	}

	public ResponseEntity<CommonApiResponse> updateCourse(AddCourseRequest course) {

		LOG.info("Request received for add course");

		CommonApiResponse response = new CommonApiResponse();

		if (course == null) {
			response.setResponseMessage("missing input");
			response.setSuccess(false);

			return new ResponseEntity<CommonApiResponse>(response, HttpStatus.BAD_REQUEST);
		}

		if (course.getId() == 0 || course.getName() == null || course.getDescription() == null || course.getGradeId() == 0) {
			response.setResponseMessage("missing input");
			response.setSuccess(false);

			return new ResponseEntity<CommonApiResponse>(response, HttpStatus.BAD_REQUEST);
		}
		
		Grade grade = this.gradeService.getGradeById(course.getGradeId());

		if (grade == null) {
			response.setResponseMessage("grade not found");
			response.setSuccess(false);

			return new ResponseEntity<CommonApiResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		Course existingCourse = this.courseService.getCourseById(course.getId());
        existingCourse.setName(course.getName());
        existingCourse.setDescription(course.getDescription());
		existingCourse.setGrade(grade);
		existingCourse.setStatus(ActiveStatus.ACTIVE.value());
		Course savedCourse = this.courseService.updateCourse(existingCourse);

		if (savedCourse == null) {
			throw new CourseSaveFailedException("Failed to update course");
		}

		response.setResponseMessage("Course Updated Successful");
		response.setSuccess(true);

		return new ResponseEntity<CommonApiResponse>(response, HttpStatus.OK);

	}

	public ResponseEntity<CourseResponseDto> fetchAllCourse() {

		LOG.info("Request received for fetching all course");

		CourseResponseDto response = new CourseResponseDto();

		List<Course> courses = new ArrayList<>();

		courses = this.courseService.getAllCoursesByStatus(ActiveStatus.ACTIVE.value());

		if (CollectionUtils.isEmpty(courses)) {
			response.setResponseMessage("No Course found");
			response.setSuccess(false);

			return new ResponseEntity<CourseResponseDto>(response, HttpStatus.OK);
		}

		response.setCourses(courses);
		response.setResponseMessage("Courses fetched successful");
		response.setSuccess(true);

		return new ResponseEntity<CourseResponseDto>(response, HttpStatus.OK);
	}

	public ResponseEntity<CourseResponseDto> fetchAllCourseByGrade(int gradeId) {

		LOG.info("Request received for fetching all course by Grade");

		CourseResponseDto response = new CourseResponseDto();

		List<Course> courses = new ArrayList<>();

		Grade grade = this.gradeService.getGradeById(gradeId);

		if (grade == null) {
			response.setResponseMessage("grade not found");
			response.setSuccess(false);

			return new ResponseEntity<CourseResponseDto>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		courses = this.courseService.getAllCoursesByGradeAndStatus(grade, ActiveStatus.ACTIVE.value());

		if (CollectionUtils.isEmpty(courses)) {
			response.setResponseMessage("No Course found");
			response.setSuccess(false);

			return new ResponseEntity<CourseResponseDto>(response, HttpStatus.OK);
		}

		response.setCourses(courses);
		response.setResponseMessage("Courses fetched successful");
		response.setSuccess(true);

		return new ResponseEntity<CourseResponseDto>(response, HttpStatus.OK);
	}

	public ResponseEntity<CommonApiResponse> deleteCourse(int courseId) {

		LOG.info("Request received for deleting grade");

		CommonApiResponse response = new CommonApiResponse();

		if (courseId == 0) {
			response.setResponseMessage("missing course Id");
			response.setSuccess(false);

			return new ResponseEntity<CommonApiResponse>(response, HttpStatus.BAD_REQUEST);
		}

		Course course = this.courseService.getCourseById(courseId);

		if (course == null) {
			response.setResponseMessage("course not found");
			response.setSuccess(false);

			return new ResponseEntity<CommonApiResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		course.setStatus(ActiveStatus.DEACTIVATED.value());
		Course updatedCourse = this.courseService.updateCourse(course);

		if (updatedCourse == null) {
			throw new GradeSaveFailedException("Failed to delete the Course");
		}

		response.setResponseMessage("Course Deleted Successful");
		response.setSuccess(true);

		return new ResponseEntity<CommonApiResponse>(response, HttpStatus.OK);

	}

	public ResponseEntity<CourseResponseDto> fetchCourseById(int courseId) {

		LOG.info("Request received for fetch course by course id");

		CourseResponseDto response = new CourseResponseDto();
		
		if (courseId == 0) {
			response.setResponseMessage("missing course Id");
			response.setSuccess(false);

			return new ResponseEntity<CourseResponseDto>(response, HttpStatus.BAD_REQUEST);
		}

		Course course = this.courseService.getCourseById(courseId);

		if (course == null) {
			response.setResponseMessage("course not found");
			response.setSuccess(false);

			return new ResponseEntity<CourseResponseDto>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.setCourses(Arrays.asList(course));
		response.setResponseMessage("Course fetched successful");
		response.setSuccess(true);

		return new ResponseEntity<CourseResponseDto>(response, HttpStatus.OK);
	}

}
