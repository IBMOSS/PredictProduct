package com.ibm.lotte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.lotte.model.QueryResult;
import com.ibm.lotte.service.HelloService;
import com.ibm.lotte.service.PredictService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/predict")
@Slf4j
public class PredictApiController {

	@Autowired
	HelloService hService;

	@Autowired
	PredictService pService;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(@RequestParam(name = "name") String name) {
		log.info(String.format("PredictApiController name = %s", name));
		return hService.getName(name);
	}

	@RequestMapping(value = "/predict", method = RequestMethod.GET)
	public @ResponseBody List<QueryResult> predict(@RequestParam String version) {
		return pService.findByQuery(version);
	}

	@RequestMapping(value = "/predict_by", method = RequestMethod.GET)
	public @ResponseBody List<QueryResult> predictByQuery(@RequestParam String version, @RequestParam String brand_nm) {
		return pService.findByQuery(version, brand_nm);
	}

}
