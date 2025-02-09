package com.timetable.service;

import java.util.List;

import com.timetable.entity.Grade;

public interface GradeService {

	Grade addGrade(Grade grade);

	Grade updateGrade(Grade grade);

	Grade getGradeById(int gradeId);

	List<Grade> getAllGradesByStatus(String status);

}
