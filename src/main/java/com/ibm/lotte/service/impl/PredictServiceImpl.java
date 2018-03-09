package com.ibm.lotte.service.impl;

import com.ibm.lotte.model.*;
import com.ibm.lotte.repository.HelloRepository;
import com.ibm.lotte.repository.PredictionHistoryRepository;
import com.ibm.lotte.repository.PredictionRepository;
import com.ibm.lotte.service.PredictService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PredictServiceImpl implements PredictService {

    @Autowired
    HelloRepository helloRepository;

    @Autowired
    PredictionRepository predictionRepository;

    @Autowired
    PredictionHistoryRepository predictionHistoryRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public String query(String name) {
        return helloRepository.getName( name );
    }

    @Override
    public List<PredictModelDto> findAll() {
        return predictionRepository.findAll().stream()
                .map( pm -> convertPredictModelToDto( pm ) )
                .collect( Collectors.toList() );
    }


    @Override
    public List<PredictModelDto> findByQuery(String version) {
        return predictionRepository.findByVersion( version ).stream()
                .map( pm -> convertPredictModelToDto( pm ) )
                .collect( Collectors.toList() );
    }

    @Override
    public List<PredictModelDto> findByQuery(String version, boolean newBrand, String condition) {

        List<PredictHistory> rsHistory = predictionHistoryRepository.findByVersionAndNewBrandAndKeyCd( version, newBrand, condition );

        // search history list;
        if (!rsHistory.isEmpty()) {
            return rsHistory.stream()
                    .map( ph -> convertPredictHistoryToDto( ph ) )
                    .collect( Collectors.toList() );
        }

        List<PredictModel> rsModel = predictionRepository.findByVersionAndNewBrandAndKeyCd( version, newBrand, condition );

        if (!rsModel.isEmpty()) {
            // save history
            rsModel.stream()
                    .map( pm -> convertPredictModelToPredictHistory( pm ) )
                    .forEach( predictHistory -> predictionHistoryRepository.save( predictHistory ) );
        }

        //return
        return rsModel.stream()
                .map( pm -> convertPredictModelToDto( pm ) )
                .collect( Collectors.toList() );
    }

    @Override
    public List<PredictModelDto> findGroupByQuery(String version, String condition) {

        List<PredictModel> rsModel = predictionRepository.findByVersionAndKeyCd( version, condition );

        // search predict list;
        if (!rsModel.isEmpty()) {
            return rsModel.stream()
                    .map( ph -> convertPredictModelToDto( ph ) )
                    .collect( Collectors.toList() );
        }

        // search  predict query to acitve tensorflow lib.


        // save history (async ?)
        //predictionHistoryRepository.save( new PredictHistory(  ) )


        //return
        return rsModel.stream()
                .map( pm -> convertPredictModelToDto( pm ) )
                .collect( Collectors.toList() );
    }

    @Override
    public List<PredictModelDtoWithSim> findAllWithSim(List<PredictModelQuery> queryList) {

        List<PredictModel> rsModel = predictionRepository.findAll();
        List<PredictModelDtoWithSim> dtoList = new ArrayList<>();
        List<Double> flist = Arrays.asList( 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0 );
        // search predict list;
        if (!rsModel.isEmpty()) {
            rsModel.stream()
                    .map( pm -> convertPredictModelToPredictModelDtoWithSim( pm ) )
                    .forEach( (PredictModelDtoWithSim ph) -> {
                        ph.setPrediction( Arrays.asList( 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0 ) );
                        Map<String, List<Double>> mm = new HashMap<>();
                        mm.put( "sim1xxxxx", flist );
                        ph.setSim1( mm );
                        ph.setSim2( mm );
                        ph.setSim3( mm );
                        dtoList.add( ph );
                    } );
        }

        return dtoList;
    }

    private PredictModelDto convertPredictHistoryToDto(PredictHistory predictHistory) {

        return modelMapper.map( predictHistory, PredictModelDto.class );
    }

    private PredictModelDto convertPredictModelToDto(PredictModel predictModel) {
        if (predictModel == null) {
            return null;
        }
        return modelMapper.map( predictModel, PredictModelDto.class );
    }

    private PredictHistory convertPredictModelToPredictHistory(PredictModel predictModel) {
        return modelMapper.map( predictModel, PredictHistory.class );
    }

    private PredictModelDtoWithSim convertPredictModelToPredictModelDtoWithSim(PredictModel predictModel) {
        return modelMapper.map( predictModel, PredictModelDtoWithSim.class );
    }


}
