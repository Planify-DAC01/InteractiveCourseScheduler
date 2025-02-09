package com.timetable.service;

import java.util.List;

import com.timetable.entity.Batch;
import com.timetable.entity.Course;
import com.timetable.entity.TimeTable;
import com.timetable.entity.User;

public interface TimeTableService {

	TimeTable addTimeTable(TimeTable timeTable);

	TimeTable getTimeTableById(int timeTableId);

	List<TimeTable> getByBatch(Batch batch);

	List<TimeTable> getByBatchAndCourse(Batch batch, Course course);

	List<TimeTable> getByBatchAndTeacher(Batch batch, User teacher);

	List<TimeTable> saveTimeTable(List<TimeTable> timeTable);

	List<TimeTable> getByBatchAndCourseAndTeacher(Batch batch, Course course, User teacher);

	List<TimeTable> getByTeacher(User teacher);

}
