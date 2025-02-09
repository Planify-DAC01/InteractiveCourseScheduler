package com.timetable.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timetable.dao.TimeTableDao;
import com.timetable.entity.Batch;
import com.timetable.entity.Course;
import com.timetable.entity.TimeTable;
import com.timetable.entity.User;

@Service
public class TimeTableServiceImpl implements TimeTableService {

	@Autowired
	private TimeTableDao timeTableDao;

	@Override
	public TimeTable addTimeTable(TimeTable timeTable) {
		return timeTableDao.save(timeTable);
	}

	@Override
	public TimeTable getTimeTableById(int timeTableId) {
		Optional<TimeTable> optional = timeTableDao.findById(timeTableId);

		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	@Override
	public List<TimeTable> getByBatch(Batch batch) {
		// TODO Auto-generated method stub
		return timeTableDao.findByBatch(batch);
	}

	@Override
	public List<TimeTable> getByBatchAndCourse(Batch batch, Course course) {
		// TODO Auto-generated method stub
		return timeTableDao.findByBatchAndCourse(batch, course);
	}

	@Override
	public List<TimeTable> getByBatchAndTeacher(Batch batch, User teacher) {
		// TODO Auto-generated method stub
		return timeTableDao.findByBatchAndTeacher(batch, teacher);
	}

	@Override
	public List<TimeTable> saveTimeTable(List<TimeTable> timeTable) {
		// TODO Auto-generated method stub
		return timeTableDao.saveAll(timeTable);
	}

	@Override
	public List<TimeTable> getByBatchAndCourseAndTeacher(Batch batch, Course course, User teacher) {
		// TODO Auto-generated method stub
		return timeTableDao.findByBatchAndCourseAndTeacher(batch, course, teacher);
	}

	@Override
	public List<TimeTable> getByTeacher(User teacher) {
		// TODO Auto-generated method stub
		return timeTableDao.findByTeacher(teacher);
	}

}
