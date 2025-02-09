package com.timetable.dao;

import java.lang.StackWalker.Option;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.timetable.entity.Grade;

@Repository
public interface GradeDao extends JpaRepository<Grade, Integer> {

	List<Grade> findByStatus(String status);
	boolean existsByNameAndStatus(String name,String status);
}
