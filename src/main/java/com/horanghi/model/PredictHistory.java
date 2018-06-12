package com.horanghi.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Entity // This tells Hibernate to make a table out of this class
@Data
public class PredictHistory implements Serializable {

    @Column(name = "prediction", nullable = true)
    protected String prediction;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "reg_dttm", nullable = false)
    Date createAt;
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
    @Column(name = "prdct_sell_amt", nullable = false)
    private float prdctSellAmt = 0;
    @Column(name = "sim1", columnDefinition = "TEXT", nullable = true)
    private String sim1;
    @Column(name = "sim2", columnDefinition = "TEXT", nullable = true)
    private String sim2;
    @Column(name = "sim3", columnDefinition = "TEXT", nullable = true)
    private String sim3;
    @Column(name = "sim4", columnDefinition = "TEXT", nullable = true)
    private String sim4;
    @Column(name = "sim5", columnDefinition = "TEXT", nullable = true)
    private String sim5;

    public PredictHistory() {
    }

    public PredictHistory(String version,
                          boolean newBrand,
                          String keyCd,
                          String keyNm,
                          float prdctSellAmt) {
        this.version = version;
        this.newBrand = newBrand;
        this.keyCd = keyCd;
        this.keyNm = keyNm;
        this.prdctSellAmt = prdctSellAmt;
        this.createAt = new Date();
    }

    public PredictHistory(String version,
                          boolean newBrand,
                          String keyCd,
                          String keyNm,
                          float prdctSellAmt,
                          String prediction,
                          String sim1,
                          String sim2,
                          String sim3,
                          String sim4,
                          String sim5) {
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
        this.createAt = new Date();
    }

    public List<Float> getPrediction() {
        return convertList(Arrays.asList(prediction.split(",")), (s) -> Float.parseFloat(s));
    }

    private <T, U> List<U> convertList(List<T> from, Function<T, U> func) {
        return from.stream().map(func).collect(Collectors.toList());
    }


//    public String getCreateAt() {
//        SimpleDateFormat sdfDate = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
//        String strDate = sdfDate.format( this.createAt );
//        return strDate;
//    }

}
