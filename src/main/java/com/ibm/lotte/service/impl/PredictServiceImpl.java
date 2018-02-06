package com.ibm.lotte.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.lotte.repository.HelloRepository;
import com.ibm.lotte.service.PredictService;

@Service
public class PredictServiceImpl implements PredictService {

	@Autowired
	HelloRepository hRepository;
	
	@Override
	public String query(String name) {
		return hRepository.getName(name);
	}

}
