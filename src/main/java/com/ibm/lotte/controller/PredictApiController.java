package com.ibm.lotte.controller;

import com.ibm.lotte.model.PredictModel;
import com.ibm.lotte.model.PredictModelQuery;
import com.ibm.lotte.service.PredictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/predict")
@Slf4j
public class PredictApiController {

    @Autowired
    PredictService predictService;


    @RequestMapping(value = "/find", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    List<PredictModel> predictOneBy(@RequestBody PredictModelQuery condition) {
        return predictService.findByQuery( condition.getVersion(), condition.isNewBrand(), condition.toCondition() ).stream()
                .sorted( Comparator.comparing( PredictModel::getPred ).reversed() ).collect( Collectors.toList() );
    }

    @RequestMapping(value = "/findgroup", method = RequestMethod.POST)
    public @ResponseBody
    List<PredictModel> predictGroupBy(@RequestBody PredictModelQuery condition) {

        return predictService.findAll().stream().sorted( Comparator.comparing( PredictModel::getPred ).reversed() ).collect( Collectors.toList() );
    }


}
