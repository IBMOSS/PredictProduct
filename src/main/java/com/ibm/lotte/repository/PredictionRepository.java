package com.ibm.lotte.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.lotte.model.QueryResult;

@Repository
public interface PredictionRepository extends CrudRepository<QueryResult, Long> {

	List<QueryResult> findByVersion(String version);

	List<QueryResult> findByVersionAndBrandNm(String version, String brandNm);

	List<QueryResult> findAll();

}
