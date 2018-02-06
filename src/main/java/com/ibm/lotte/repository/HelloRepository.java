package com.ibm.lotte.repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class HelloRepository {

	@Autowired
	RestTemplate restTemplate;

	public String getName(String name) {
		log.info(String.format(" name = %s", name));
		Map<String, String> map = new HashMap<>();
		map.put("name", name);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Map<String, String>> requestBody = new HttpEntity<>(map, headers);
		MapName rsMap = restTemplate.postForObject("http://127.0.0.1:8070/beckend/hello", requestBody, MapName.class);
		log.info(String.format(" remote return %s ", rsMap.toString()));
		return rsMap.toString();
	}

	public String getNameG(String name) {
		log.info(String.format(" name = %s", name));
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<MapName> entity = new HttpEntity<MapName>(headers);

		ResponseEntity<MapName> rsMap = restTemplate.exchange("http://127.0.0.1:8070/beckend/hello?name=" + name,
				HttpMethod.GET, entity, MapName.class);

		MapName rs = rsMap.getBody();

		log.info(String.format(" remote return %s ", rs.toString()));
		return rs.toString();
	}

	public String getNamePlain(String name) {
		log.info(String.format(" name = %s", name));
		HttpHeaders headers = new HttpHeaders();

		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<String> rsMap = restTemplate.exchange("http://127.0.0.1:8070/beckend/hello?name=" + name,
				HttpMethod.GET, entity, String.class);

		String rs = rsMap.getBody();

		log.info(String.format(" remote return %s ", rs.toString()));
		return rs.toString();
	}

}

class MapName {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	MapName() {
	}

	MapName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format(" MapName attr name : %s ", this.name);
	}
}

//// HttpHeaders
// HttpHeaders headers = new HttpHeaders();
//
// headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON
//// }));
//// Request to return JSON format
// headers.setContentType(MediaType.APPLICATION_JSON);
// headers.set("my_other_key", "my_other_value");
//
//// HttpEntity<String>: To get result as String.
// HttpEntity<String> entity = new HttpEntity<String>(headers);
//
//// RestTemplate
// RestTemplate restTemplate = new RestTemplate();
//
//// Send request with GET method, and Headers.
// ResponseEntity<String> response = restTemplate.exchange(URL_EMPLOYEES, //
// HttpMethod.GET, entity, String.class);

// HttpHeaders headers = new HttpHeaders();
// headers.add("Accept", MediaType.APPLICATION_XML_VALUE);
// headers.setContentType(MediaType.APPLICATION_XML);
//
// RestTemplate restTemplate = new RestTemplate();
//
//// Data attached to the request.
// HttpEntity<Employee> requestBody = new HttpEntity<>(newEmployee, headers);
//
//// Send request with POST method.
// Employee e = restTemplate.postForObject(URL_CREATE_EMPLOYEE, requestBody,
// Employee.class);
