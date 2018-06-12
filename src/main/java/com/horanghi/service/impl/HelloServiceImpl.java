package com.horanghi.service.impl;

import com.horanghi.repository.HelloRepository;
import com.horanghi.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    HelloRepository hRepository;

    @Override
    public String getName(String name) {
        return hRepository.getNamePlain(name);
    }

}
