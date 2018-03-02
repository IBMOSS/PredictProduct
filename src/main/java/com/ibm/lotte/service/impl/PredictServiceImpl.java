package com.ibm.lotte.service.impl;

import com.ibm.lotte.model.PredictModel;
import com.ibm.lotte.repository.HelloRepository;
import com.ibm.lotte.repository.PredictionRepository;
import com.ibm.lotte.service.PredictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PredictServiceImpl implements PredictService {

    @Autowired
    HelloRepository helloRepository;

    @Autowired
    PredictionRepository predictionRepository;

    @Override
    public String query(String name) {
        return helloRepository.getName( name );
    }

    @Override
    public List<PredictModel> findAll() {
        return predictionRepository.findAll();
    }

    @Override
    public List<PredictModel> findByQuery(String version) {
        return predictionRepository.findByVersion( version );
    }

    @Override
    public List<PredictModel> findByQuery(String version, boolean newBrand, String condition) {
        return predictionRepository.findByVersionAndNewBrandAndKeyCd( version, newBrand, condition );
    }

}
