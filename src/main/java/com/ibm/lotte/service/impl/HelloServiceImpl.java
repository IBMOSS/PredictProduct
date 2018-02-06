package com.ibm.lotte.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.lotte.repository.HelloRepository;
import com.ibm.lotte.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService {

	@Autowired
	HelloRepository hRepository;

	@Override
	public String getName(String name) {
		return hRepository.getNamePlain(name);
	}

}
