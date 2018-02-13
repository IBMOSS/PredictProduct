package com.ibm.lotte.repository;

import java.util.List;

import com.ibm.lotte.model.PredictModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PredictionRepository extends CrudRepository<PredictModel, Long> {

	List<PredictModel> findByVersion(String version);

	List<PredictModel> findByVersionAndCondition(String version, String condition);

	List<PredictModel> findAll();

}
