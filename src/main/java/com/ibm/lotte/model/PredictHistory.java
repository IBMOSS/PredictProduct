package com.ibm.lotte.model;


import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
@Data
public class PredictHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "model_ver_no", nullable = false)
    private String version;

    @Column(name = "new_brand_yn", nullable = false)
    private boolean newBrand;

    @Column(name = "key_cd", nullable = false)
    private String keyCd;

    @Column(name = "key_nm", nullable = false)
    private String keyNm;

    @Column(name = "prdct_woy", nullable = false)
    private String predWOY;

    @Column(name = "prdct_sell_amt",  nullable = false)
    private float pred = 0;

    @Column(name = "prediction", nullable = true)
    private String prediction;

    @Column(name = "sim1", nullable = true)
    private String sim1;

    @Column(name = "sim2", nullable = true)
    private String sim2;

    @Column(name = "sim3", nullable = true)
    private String sim3;

    @Column(name = "sim4", nullable = true)
    private String sim4;

    @Column(name = "sim5", nullable = true)
    private String sim5;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "reg_dttm", nullable = false)
    Date createAt;

    public PredictHistory() {
    }

    public PredictHistory(String version,
                          boolean newBrand,
                          String predWOY,
                          String keyCd,
                          String keyNm,
                          float pred) {
        this.version = version;
        this.newBrand = newBrand;
        this.keyCd = keyCd;
        this.keyNm = keyNm;
        this.predWOY = predWOY;
        this.pred = pred;
        this.createAt = new Date();
    }


    public PredictHistory(String version,
                          boolean newBrand,
                          String predWOY,
                          String keyCd,
                          String keyNm,
                          float pred,
                          String prediction,
                          String sim1,
                          String sim2,
                          String sim3,
                          String sim4) {
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
        this.createAt = new Date();
    }


//    public String getCreateAt() {
//        SimpleDateFormat sdfDate = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
//        String strDate = sdfDate.format( this.createAt );
//        return strDate;
//    }

}
