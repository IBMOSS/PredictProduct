package com.ibm.lotte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.lotte.service.HelloService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/predict")
@Slf4j
public class PredictApiController {

	@Autowired
	HelloService hService;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(@RequestParam(name="name") String name) {
		log.info(String.format("PredictApiController name = %s", name));
		return hService.getName(name);
	}

}
