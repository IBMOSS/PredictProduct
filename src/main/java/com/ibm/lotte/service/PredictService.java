package com.ibm.lotte.service;

import java.util.List;

import com.ibm.lotte.model.PredictModel;

public interface PredictService {

    public String query(String name);

    public List<PredictModel> findAll();

    public List<PredictModel> findByQuery(String version);

    public List<PredictModel> findByQuery(String version, String condition);

}
