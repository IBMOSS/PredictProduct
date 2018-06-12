package com.horanghi.model;

import com.google.common.base.Joiner;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.stream.Collectors;

@Data
@Slf4j
public class PredictModelQuery {

    private String version = "";

    private boolean newBrand = false;

    private String brand_cd = "";

    private String func_cd = "";

    private String maker_cd = "";

    private String mat_1_cd = "";

    private String mat_2_cd = "";

    private String mat_3_cd = "";

    private String mat_4_cd = "";

    private String mat_5_cd = "";

    private String mat_6_cd = "";

    private String prod_cat_2_cd = "";

    private String prod_cat_3_cd = "";

    private String taste_1_cd = "";

    private String taste_2_cd = "";

    private String taste_3_cd = "";

    private String txtre_1_cd = "";

    private String txtre_2_cd = "";

    private String txtre_3_cd = "";


    public String toCondition() {
        String delimiter = "_";

        String mats = Joiner.on(delimiter).join(Arrays.asList(mat_1_cd, mat_2_cd, mat_3_cd, mat_4_cd, mat_5_cd, mat_6_cd).stream()
                .sorted().collect(Collectors.toList()));
        String prodCats = Joiner.on(delimiter).join(Arrays.asList(prod_cat_2_cd, prod_cat_3_cd).stream()
                .sorted().collect(Collectors.toList()));
        String tastes = Joiner.on(delimiter).join(Arrays.asList(taste_1_cd, taste_2_cd, taste_3_cd).stream()
                .sorted().collect(Collectors.toList()));
        String txtres = Joiner.on(delimiter).join(Arrays.asList(txtre_1_cd, txtre_2_cd, txtre_3_cd).stream()
                .sorted().collect(Collectors.toList()));
        String cons = Joiner.on(delimiter).join(Arrays.asList(getBrand_cd(), getFunc_cd(), getMaker_cd(), mats, prodCats, tastes, txtres).toArray());

        log.debug(String.format("to Condition : %s ", cons));

        return cons;

    }


}
