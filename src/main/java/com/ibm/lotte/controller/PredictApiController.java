package com.ibm.lotte.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.ibm.lotte.model.PredictModel;
import com.ibm.lotte.model.PredictModelQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ibm.lotte.service.PredictService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/predict")
@Slf4j
public class PredictApiController {

    @Autowired
    PredictService predictService;


    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public @ResponseBody
    List<PredictModel> predictOneBy(@RequestBody PredictModelQuery condition) {
        return predictService.findByQuery( condition.getVersion(), condition.toCondition() ).stream()
                .sorted( Comparator.comparing( PredictModel::getPred ).reversed() ).collect( Collectors.toList() );
    }

    @RequestMapping(value = "/findgroup", method = RequestMethod.POST)
    public @ResponseBody
    List<PredictModel> predictGroupBy(@RequestBody PredictModelQuery condition) {

        return predictService.findAll().stream().sorted( Comparator.comparing( PredictModel::getPred ).reversed() ).collect( Collectors.toList() );
    }
}
