package com.ibm.lotte.service;

import java.util.List;

import com.ibm.lotte.model.QueryResult;

public interface PredictService {

	public String query(String name);

	public List<QueryResult> findAll();

	public List<QueryResult> findByQuery(String version);

	public List<QueryResult> findByQuery(String version, String brand_nm);

}
