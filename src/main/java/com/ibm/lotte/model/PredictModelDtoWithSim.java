package com.ibm.lotte.model;


import lombok.Data;
import lombok.Setter;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
public class PredictModelDtoWithSim implements Serializable {

    private String version;

    private boolean newBrand;

    private String keyCd;

    private String keyNm;

    private String predWOY;

    private float pred;

    private List<Double> prediction;

    private Map<String, List<Double>> sim1;

    private Map<String, List<Double>> sim2;

    private Map<String, List<Double>> sim3;

    private Map<String, List<Double>> sim4;

    private Map<String, List<Double>> sim5;


    @Setter
    private Date createAt;

    public PredictModelDtoWithSim() {
    }

    public PredictModelDtoWithSim(String version,
                                  boolean newBrand,
                                  String predWOY,
                                  String keyCd,
                                  String keyNm,
                                  float pred,
                                  List prediction,
                                  Map sim1,
                                  Map sim2,
                                  Map sim3,
                                  Map sim4,
                                  Map sim5,
                                  Date createAt) {
        this.version = version;
        this.newBrand = newBrand;
        this.keyCd = keyCd;
        this.keyNm = keyNm;
        this.predWOY = predWOY;
        this.pred = pred;
        this.prediction = prediction;
        this.sim1 = sim1;
        this.sim2 = sim2;
        this.sim3 = sim3;
        this.sim4 = sim4;
        this.sim5 = sim5;
        this.createAt = createAt;
    }

    public String getCreateAt() {
        SimpleDateFormat sdfDate = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        String strDate = sdfDate.format( this.createAt );
        return strDate;
    }

}
