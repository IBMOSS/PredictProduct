package com.ibm.lotte.repository;

import java.util.Date;
import java.util.List;

import com.ibm.lotte.model.PredictHistory;
import com.ibm.lotte.model.PredictModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PredictionRepository extends CrudRepository<PredictModel, Long> {

	List<PredictModel> findByVersion(String version);

	List<PredictModel> findByVersionAndNewBrandAndKeyCd(String version, boolean newBrand, String condition);

	List<PredictModel> findByVersionAndKeyCd(String version, String condition);

	List<PredictModel> findByCreateAt(Date createAt);

	List<PredictModel> findAll();

}
