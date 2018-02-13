package com.ibm.lotte.model;

import lombok.Data;

@Data
public class PredictModelQuery {

    private String version = "";

    private String brand_nm = "";

    private String func_nm = "";

    private String maker_nm = "";

    private String mat_1_nm = "";

    private String mat_2_nm = "";

    private String mat_3_nm = "";

    private String mat_4_nm = "";

    private String mat_5_nm = "";

    private String mat_6_nm = "";

    private String prod_cat_2_nm = "";

    private String prod_cat_3_nm = "";

    private String taste_1_nm = "";

    private String taste_2_nm = "";

    private String taste_3_nm = "";

    private String txtre_1_nm = "";

    private String txtre_2_nm = "";

    private String txtre_3_nm = "";

    public String toCondition() {
        return  brand_nm + "_" + func_nm + "_" + maker_nm + "_"
                + mat_1_nm + "_" + mat_2_nm + "_" + mat_3_nm + "_" + mat_4_nm + "_" + mat_5_nm + "_" + mat_6_nm + "_"
                + prod_cat_2_nm + "_" + prod_cat_3_nm + "_" + taste_1_nm + "_" + taste_2_nm + "_" + taste_3_nm + "_"
                + txtre_1_nm + "_" + txtre_2_nm + "_" + txtre_3_nm;
    }

}
