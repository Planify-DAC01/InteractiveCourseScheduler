package com.timetable.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timetable.dao.GradeDao;
import com.timetable.entity.Grade;

@Service
public class GradeServiceImpl implements GradeService {

	@Autowired
	private GradeDao gradeDao;

	@Override
	public Grade addGrade(Grade grade) {
		return gradeDao.save(grade);
	}

	@Override
	public Grade updateGrade(Grade grade) {
		return gradeDao.save(grade);
	}

	@Override
	public Grade getGradeById(int gradeId) {
		Optional<Grade> optionalGrade = gradeDao.findById(gradeId);

		if (optionalGrade.isPresent()) {
			return optionalGrade.get();
		} else {
			return null;
		}
	}

	@Override
	public List<Grade> getAllGradesByStatus(String status) {
		return this.gradeDao.findByStatus(status);
	}

}
