package com.timetable.service;

import java.util.List;

import com.timetable.entity.Batch;
import com.timetable.entity.Grade;

public interface BatchService {
	
	Batch addBatch(Batch batch);

	Batch updateBatch(Batch batch);

	Batch getBatchById(int batchId);

	List<Batch> getAllBatchsByStatus(String status);
	
	List<Batch> getAllBatchsByGradeAndStatus(Grade grade, String status);

}
