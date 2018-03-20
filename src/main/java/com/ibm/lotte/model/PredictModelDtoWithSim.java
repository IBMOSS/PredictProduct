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

    private float prdctSellAmt;

    private List<Float> prediction;

    private Sim sim1;

    private Sim sim2;

    private Sim sim3;

    private Sim sim4;

    private Sim sim5;


    @Setter
    private Date createAt;

    public PredictModelDtoWithSim() {
    }

    public PredictModelDtoWithSim(String version,
                                  boolean newBrand,
                                  String keyCd,
                                  String keyNm,
                                  float prdctSellAmt,
                                  List<Float> prediction,
                                  Sim sim1,
                                  Sim sim2,
                                  Sim sim3,
                                  Sim sim4,
                                  Sim sim5,
                                  Date createAt) {
        this.version = version;
        this.newBrand = newBrand;
        this.keyCd = keyCd;
        this.keyNm = keyNm;
        this.prdctSellAmt = prdctSellAmt;
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
