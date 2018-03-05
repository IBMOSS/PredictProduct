package com.ibm.lotte.service;

import com.ibm.lotte.model.PredictModelDto;

import java.util.List;

public interface PredictService {

    public String query(String name);

    public List<PredictModelDto> findAll();

    public List<PredictModelDto> findByQuery(String version);

    public List<PredictModelDto> findByQuery(String version, boolean newBrand, String condition);

    public List<PredictModelDto> findGroupByQuery(String version, String condition);

}
