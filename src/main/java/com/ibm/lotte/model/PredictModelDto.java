package com.ibm.lotte.model;


import lombok.Data;
import lombok.Setter;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class PredictModelDto implements Serializable {

    private String version;

    private boolean newBrand;

    private String keyCd;

    private String keyNm;

    private String predWOY;

    private float pred;

    @Setter
    private Date createAt;

    public PredictModelDto() {
    }

    public PredictModelDto(String version,
                           boolean newBrand,
                           String predWOY,
                           String keyCd,
                           String keyNm,
                           float pred,
                           Date createAt) {
        this.version = version;
        this.newBrand = newBrand;
        this.keyCd = keyCd;
        this.keyNm = keyNm;
        this.predWOY = predWOY;
        this.pred = pred;
        this.createAt = createAt;
    }

    public String getCreateAt() {
        SimpleDateFormat sdfDate = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        String strDate = sdfDate.format( this.createAt );
        return strDate;
    }

}
