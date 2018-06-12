package com.horanghi.service;

import com.horanghi.model.PredictHistoryQuery;
import com.horanghi.model.PredictModelDto;
import com.horanghi.model.PredictModelDtoWithSim;
import com.horanghi.model.PredictModelQuery;

import java.util.List;

public interface PredictService {

    public String query(String name);

    public List<PredictModelDto> findAll();

    public List<PredictModelDto> findByQuery(String version);

    public List<PredictModelDto> findByQuery(String version, boolean newBrand, String condition);

    public List<PredictModelDto> findGroupByQuery(String version, String condition);

    public List<PredictModelDtoWithSim> findAllWithSim(List<PredictModelQuery> condition);

    public List<PredictModelDtoWithSim> findHistory(PredictHistoryQuery query);
}
