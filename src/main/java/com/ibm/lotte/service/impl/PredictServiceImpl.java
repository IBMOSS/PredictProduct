package com.ibm.lotte.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.lotte.model.QueryResult;
import com.ibm.lotte.repository.HelloRepository;
import com.ibm.lotte.repository.PredictionRepository;
import com.ibm.lotte.service.PredictService;

@Service
public class PredictServiceImpl implements PredictService {

	@Autowired
	HelloRepository hRepository;

	@Autowired
	PredictionRepository pRepository;

	@Override
	public String query(String name) {
		return hRepository.getName(name);
	}

	@Override
	public List<QueryResult> findAll() {
		return pRepository.findAll();
	}
}
