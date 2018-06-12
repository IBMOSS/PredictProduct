package com.horanghi.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.horanghi.model.*;
import com.ibm.lotte.model.*;
import com.horanghi.repository.HelloRepository;
import com.horanghi.repository.PredictionHistoryRepository;
import com.horanghi.repository.PredictionRepository;
import com.horanghi.service.PredictService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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


    ObjectMapper mapper = new ObjectMapper();

    @Override
    public String query(String name) {
        return helloRepository.getName(name);
    }

    @Override
    public List<PredictModelDto> findAll() {
        return predictionRepository.findAll().stream()
                .map(pm -> convertPredictModelToDto(pm))
                .collect(Collectors.toList());
    }


    @Override
    public List<PredictModelDto> findByQuery(String version) {
        return predictionRepository.findByVersion(version).stream()
                .map(pm -> convertPredictModelToDto(pm))
                .collect(Collectors.toList());
    }

    @Override
    public List<PredictModelDto> findByQuery(String version, boolean newBrand, String condition) {

        List<PredictHistory> rsHistory = predictionHistoryRepository.findByVersionAndNewBrandAndKeyCd(version, newBrand, condition);

        // search history list;
        if (!rsHistory.isEmpty()) {
            return rsHistory.stream()
                    .map(ph -> convertPredictHistoryToDto(ph))
                    .collect(Collectors.toList());
        }

        List<PredictModel> rsModel = predictionRepository.findByVersionAndNewBrandAndKeyCd(version, newBrand, condition);

        if (!rsModel.isEmpty()) {
            // save history
            rsModel.stream()
                    .map(pm -> convertPredictModelToPredictHistory(pm))
                    .forEach(predictHistory -> predictionHistoryRepository.save(predictHistory));
        }

        //return
        return rsModel.stream()
                .map(pm -> convertPredictModelToDto(pm))
                .collect(Collectors.toList());
    }

    @Override
    public List<PredictModelDto> findGroupByQuery(String version, String condition) {

        List<PredictModel> rsModel = predictionRepository.findByVersionAndKeyCd(version, condition);

        // search predict list;
        if (!rsModel.isEmpty()) {
            return rsModel.stream()
                    .map(ph -> convertPredictModelToDto(ph))
                    .collect(Collectors.toList());
        }

        // search  predict query to acitve tensorflow lib.


        // save history (async ?)
        //predictionHistoryRepository.save( new PredictHistory(  ) )


        //return
        return rsModel.stream()
                .map(pm -> convertPredictModelToDto(pm))
                .collect(Collectors.toList());
    }

    @Override
    public List<PredictModelDtoWithSim> findAllWithSim(List<PredictModelQuery> queryList) {

        List<PredictModel> rsModel = predictionRepository.findAll();
        List<PredictModelDtoWithSim> dtoList = new ArrayList<>();

        if (!rsModel.isEmpty()) {
            rsModel.stream()
                    .forEach((PredictModel pm) -> {
                        if (predictionHistoryRepository.findByVersionAndNewBrandAndKeyCd(pm.getVersion(), Boolean.FALSE, pm.getKeyCd()).isEmpty()) {
                            PredictHistory phh = new PredictHistory(
                                    pm.getVersion(), Boolean.FALSE, pm.getKeyCd(), pm.getKeyNm(), pm.getPrdctSellAmt(),
                                    pm.getPredictionStr(), pm.getSim1(), pm.getSim2(), pm.getSim3(), pm.getSim4(), pm.getSim5());
                            predictionHistoryRepository.save(phh);
                        }
                        dtoList.add(convertPredictModelToPredictModelDtoWithSim(pm));
                    });
        }

        return dtoList;
    }

    @Override
    public List<PredictModelDtoWithSim> findHistory(PredictHistoryQuery query) {

        List<PredictHistory> rsModel = predictionHistoryRepository.findByVersion(query.getVersionNo());
        List<PredictModelDtoWithSim> dtoList = new ArrayList<>();
        if (!rsModel.isEmpty()) {
            dtoList = rsModel.stream()
                    .map(ph -> convertPredictHistoryToPredictModelDtoWithSim(ph)).collect(Collectors.toList());
        }

        return dtoList;
    }

    private PredictModelDto convertPredictHistoryToDto(PredictHistory predictHistory) {

        return modelMapper.map(predictHistory, PredictModelDto.class);
    }

    private PredictModelDto convertPredictModelToDto(PredictModel predictModel) {
        if (predictModel == null) {
            return null;
        }
        return modelMapper.map(predictModel, PredictModelDto.class);
    }

    private PredictHistory convertPredictModelToPredictHistory(PredictModel predictModel) {
        PredictHistory rs = modelMapper.map(predictModel, PredictHistory.class);
        return rs;
    }

    private PredictModelDtoWithSim convertPredictHistoryToPredictModelDtoWithSim(PredictHistory ph) {
        PredictModelDtoWithSim rs = modelMapper.map(ph, PredictModelDtoWithSim.class);
        try {
            if (ph.getSim1() != null) {
                rs.setSim1(mapper.readValue(ph.getSim1(), Sim.class));
            }
            if (ph.getSim2() != null) {
                rs.setSim2(mapper.readValue(ph.getSim2(), Sim.class));
            }
            if (ph.getSim3() != null) {
                rs.setSim3(mapper.readValue(ph.getSim3(), Sim.class));
            }
            if (ph.getSim4() != null) {
                rs.setSim4(mapper.readValue(ph.getSim4(), Sim.class));
            }
            if (ph.getSim5() != null) {
                rs.setSim5(mapper.readValue(ph.getSim5(), Sim.class));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return rs;
    }


    private PredictModelDtoWithSim convertPredictModelToPredictModelDtoWithSim(PredictModel predictModel) {
        PredictModelDtoWithSim rs = modelMapper.map(predictModel, PredictModelDtoWithSim.class);
        try {
            if (predictModel.getSim1() != null) {
                rs.setSim1(mapper.readValue(predictModel.getSim1(), Sim.class));
            }
            if (predictModel.getSim2() != null) {
                rs.setSim2(mapper.readValue(predictModel.getSim2(), Sim.class));
            }
            if (predictModel.getSim3() != null) {
                rs.setSim3(mapper.readValue(predictModel.getSim3(), Sim.class));
            }
            if (predictModel.getSim4() != null) {
                rs.setSim4(mapper.readValue(predictModel.getSim4(), Sim.class));
            }
            if (predictModel.getSim5() != null) {
                rs.setSim5(mapper.readValue(predictModel.getSim5(), Sim.class));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return rs;
    }

    private PredictModelDto convertPredictModelToPredictModelDto(PredictHistory predictHistory) {
        return modelMapper.map(predictHistory, PredictModelDto.class);
    }

}
