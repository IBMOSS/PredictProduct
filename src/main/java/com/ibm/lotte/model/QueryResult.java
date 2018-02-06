package com.ibm.lotte.model;

import lombok.Data;

@Data
public class QueryResult {

	String resultStatement;
	float score;

	public QueryResult(String result, float score) {
		this.resultStatement = result;
		this.score = score;
	}

}
