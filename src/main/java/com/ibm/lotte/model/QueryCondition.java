package com.ibm.lotte.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class QueryCondition {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String version;
	private String param1;
/*
 * ....
 */
	// @javax.persistence.Temporal(TemporalType.TIMESTAMP) // java.util.Date이므로
	// @Temporal을 붙여준다.
	// @Column(name = "created_at", updatable = false)
	// private Date createdDateTime;
	//
	// @javax.persistence.Temporal(TemporalType.TIMESTAMP) // java.util.Date이므로
	// @Temporal을 붙여준다.
	// @Column(name = "last_modified_at", updatable = true)
	// private Date lastModifiedDateTime;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

}
