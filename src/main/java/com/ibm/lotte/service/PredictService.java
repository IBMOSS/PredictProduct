package com.ibm.lotte.service;

import com.ibm.lotte.model.PredictHistory;
import com.ibm.lotte.model.PredictModelDto;
import com.ibm.lotte.model.PredictModelDtoWithSim;
import com.ibm.lotte.model.PredictModelQuery;

import java.util.List;

public interface PredictService {

    public String query(String name);

    public List<PredictModelDto> findAll();

    public List<PredictModelDto> findByQuery(String version);

    public List<PredictModelDto> findByQuery(String version, boolean newBrand, String condition);

    public List<PredictModelDto> findGroupByQuery(String version, String condition);

    public List<PredictModelDtoWithSim> findAllWithSim(List<PredictModelQuery> condition);
}
