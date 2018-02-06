package com.ibm.lotte.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity // This tells Hibernate to make a table out of this class
@Data
public class QueryResult {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String version;
	private String cond;
	private String prediction;
	private float score;
	/*
	 * ....
	 */

	// @Column(name = "created_at", updatable = false)
	// private Date createdDateTime;
	//
	// @Column(name = "last_modified_at", updatable = true)
	// private Date lastModifiedDateTime;
	public QueryResult() {
	}

	public QueryResult(String version, String cond, String prediction, float score) {
		this.version = version;
		this.cond = cond;
		this.prediction = prediction;
		this.score = score;

	}

	@Override
	public String toString() {
		return String.format("QueryResult[version=%s, condition='%s', prediction='%s', score='%f']", version, cond,
				prediction, score);
	}

}
