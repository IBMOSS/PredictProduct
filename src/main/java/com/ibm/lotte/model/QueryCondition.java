package com.ibm.lotte.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
@Data
public class QueryCondition {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String version;

	private String brand_nm;

	private String func_nm;

	private String maker_nm;

	private String mat_1_nm;

	private String mat_2_nm;

	private String mat_3_nm;

	private String mat_4_nm;

	private String mat_5_nm;

	private String mat_6_nm;

	private String prod_cat_2_nm;

	private String prod_cat_3_nm;

	private String taste_1_nm;

	private String taste_2_nm;

	private String taste_3_nm;

	private String txtre_1_nm;

	private String txtre_2_nm;

	private String txtre_3_nm;
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




}
