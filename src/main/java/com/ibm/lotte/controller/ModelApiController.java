package com.ibm.lotte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.lotte.service.HelloService;

@RestController
@RequestMapping("/model")
public class ModelApiController {

	@Autowired
	HelloService hService;

	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String hello(String name) {
		return hService.getName(name);
	}

}
