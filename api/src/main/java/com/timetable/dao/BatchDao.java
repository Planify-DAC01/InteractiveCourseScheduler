package com.timetable.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.timetable.entity.Batch;
import com.timetable.entity.Grade;

@Repository
public interface BatchDao extends JpaRepository<Batch, Integer> {

	List<Batch> findByGradeAndStatus(Grade grade, String status);

	List<Batch> findByStatus(String status);
	boolean existsByNameAndStatusAndGrade(String name, String status, Grade grade);

}
