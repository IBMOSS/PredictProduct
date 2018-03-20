package com.ibm.lotte.model;


import lombok.Data;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Data
public class PredictModelDto implements Serializable {

    private String version;

    private boolean newBrand;

    private String keyCd;

    private String keyNm;

    private float prdctSellAmt;

    private List<Float> prediction;

    @Setter
    private Date createAt;

    public PredictModelDto() {
    }

    public PredictModelDto(String version,
                           boolean newBrand,
                           String keyCd,
                           String keyNm,
                           float prdctSellAmt,
                           List<Float> prediction,
                           Date createAt) {
        this.version = version;
        this.newBrand = newBrand;
        this.keyCd = keyCd;
        this.keyNm = keyNm;
        this.prdctSellAmt = prdctSellAmt;
        this.prediction = prediction;
        this.createAt = createAt;
    }

    public String getCreateAt() {
        SimpleDateFormat sdfDate = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        String strDate = sdfDate.format( this.createAt );
        return strDate;
    }

}
