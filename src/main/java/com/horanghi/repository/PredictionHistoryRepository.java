package com.horanghi.repository;

import com.horanghi.model.PredictHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PredictionHistoryRepository extends CrudRepository<PredictHistory, Long> {

    List<PredictHistory> findByVersion(String version);

    List<PredictHistory> findByVersionAndCreateAt(String version, Date createAt);

    List<PredictHistory> findByVersionAndNewBrandAndKeyCd(String version, boolean newBrand, String condition);

    List<PredictHistory> findByVersionAndKeyCd(String version, String condition);

    List<PredictHistory> findByCreateAt(Date createAt);

    List<PredictHistory> findAll();

}
