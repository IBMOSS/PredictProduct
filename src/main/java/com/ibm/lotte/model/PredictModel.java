package com.ibm.lotte.model;

import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
@Data
public class PredictModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String version;

    @Column(name = "cond")
    private String condition;


    @Column(name = "key_nm")
    private String keyNm;

    @Column(name = "pred")
    private float pred;

    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    java.util.Date createAt;

    public PredictModel() {
    }

    public PredictModel(String version,
                        String condition,
                        String key_nm,
                        float pred) {
        this.version = version;
        this.condition = condition;
        this.keyNm = key_nm;
        this.pred = pred;
        this.createAt = new Date();
    }

    public String getCreateAt(){
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = sdfDate.format(this.createAt);
        return strDate;
    }
//    public PredictModel(String version,
//                        String brand_nm,
//                        String func_nm,
//                        String maker_nm,
//                        String mat_1_nm,
//                        String mat_2_nm,
//                        String mat_3_nm,
//                        String mat_4_nm,
//                        String mat_5_nm,
//                        String mat_6_nm,
//                        String prod_cat_2_nm,
//                        String prod_cat_3_nm,
//                        String taste_1_nm,
//                        String taste_2_nm,
//                        String taste_3_nm,
//                        String txtre_1_nm,
//                        String txtre_2_nm,
//                        String txtre_3_nm,
//                        String key_nm,
//                        float pred) {
//        this.version = version;
//        this.brandNm = brand_nm;
//        this.funcNm = func_nm;
//        this.makerNm = maker_nm;
//        this.mat1Nm = mat_1_nm;
//        this.mat2Nm = mat_2_nm;
//        this.mat3Nm = mat_3_nm;
//        this.mat4Nm = mat_4_nm;
//        this.mat5Nm = mat_5_nm;
//        this.mat6Nm = mat_6_nm;
//        this.prodCat2Nm = prod_cat_2_nm;
//        this.prodCat3Nm = prod_cat_3_nm;
//        this.taste1Nm = taste_1_nm;
//        this.taste2Nm = taste_2_nm;
//        this.taste3Nm = taste_3_nm;
//        this.txtre1Nm = txtre_1_nm;
//        this.txtre2Nm = txtre_2_nm;
//        this.txtre3Nm = txtre_3_nm;
//        this.keyNm = key_nm;
//        this.pred = pred;
//    }


//    @Column(name = "func_nm")
//    private String funcNm;
//
//    @Column(name = "maker_nm")
//    private String makerNm;
//
//    @Column(name = "mat_1_nm")
//    private String mat1Nm;
//
//    @Column(name = "mat_2_nm")
//    private String mat2Nm;
//
//    @Column(name = "mat_3_nm")
//    private String mat3Nm;
//
//    @Column(name = "mat_4_nm")
//    private String mat4Nm;
//
//    @Column(name = "mat_5_nm")
//    private String mat5Nm;
//
//    @Column(name = "mat_6_nm")
//    private String mat6Nm;
//
//    @Column(name = "prod_cat_2_nm")
//    private String prodCat2Nm;
//
//    @Column(name = "prod_cat_3_nm")
//    private String prodCat3Nm;
//
//    @Column(name = "taste_1_nm")
//    private String taste1Nm;
//
//    @Column(name = "taste_2_nm")
//    private String taste2Nm;
//
//    @Column(name = "taste_3_nm")
//    private String taste3Nm;
//
//    @Column(name = "txtre_1_nm")
//    private String txtre1Nm;
//
//    @Column(name = "txtre_2_nm")
//    private String txtre2Nm;
//
//    @Column(name = "txtre_3_nm")
//    private String txtre3Nm;
}
