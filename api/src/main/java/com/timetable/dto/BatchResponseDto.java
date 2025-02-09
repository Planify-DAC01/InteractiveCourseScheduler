package com.timetable.dto;

import java.util.ArrayList;
import java.util.List;

import com.timetable.entity.Batch;

public class BatchResponseDto extends CommonApiResponse {

	private List<Batch> batches = new ArrayList<>();

	public List<Batch> getBatchs() {
		return batches;
	}

	public void setBatchs(List<Batch> batches) {
		this.batches = batches;
	}

}
