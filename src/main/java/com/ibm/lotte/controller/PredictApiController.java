package com.ibm.lotte.controller;

import com.ibm.lotte.model.PredictHistoryQuery;
import com.ibm.lotte.model.PredictModelDto;
import com.ibm.lotte.model.PredictModelDtoWithSim;
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
    List<PredictModelDto> predictOneBy(@RequestBody PredictModelQuery condition) {
        return predictService.findByQuery( condition.getVersion(), condition.isNewBrand(), condition.toCondition() ).stream()
                .sorted( Comparator.comparing( PredictModelDto::getPrdctSellAmt ).reversed() ).collect( Collectors.toList() );
    }


    @RequestMapping(value = "/findSample", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    List<PredictModelDto> predictOneBy(@RequestParam(name = "version") String version, @RequestParam(name = "condition") String condition) {
        return predictService.findByQuery( version, Boolean.FALSE, condition ).stream()
                .sorted( Comparator.comparing( PredictModelDto::getPrdctSellAmt ).reversed() ).collect( Collectors.toList() );
    }

    @RequestMapping(value = "/findgroup", method = RequestMethod.POST)
    public @ResponseBody
    List<PredictModelDtoWithSim> predictGroupBy(@RequestBody List<PredictModelQuery> condition) {

        return predictService.findAllWithSim(condition).stream()
                .sorted( Comparator.comparing( PredictModelDtoWithSim::getPrdctSellAmt ).reversed() )
                .collect( Collectors.toList() );
    }

    @RequestMapping(value = "/findhistory", method = RequestMethod.POST)
    public @ResponseBody
    List<PredictModelDtoWithSim> predictHistory(@RequestBody PredictHistoryQuery condition) {

        return predictService.findHistory(condition).stream()
                .sorted( Comparator.comparing( PredictModelDtoWithSim::getPrdctSellAmt ).reversed() )
                .collect( Collectors.toList() );
    }
}
