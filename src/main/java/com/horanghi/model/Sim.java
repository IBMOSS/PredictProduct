package com.horanghi.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Sim implements Serializable {
    String keyCd;
    String keyNm;
    List<Float> values;

    public Sim() {
    }

    public Sim(String keyCd, String KeyNm, List<Float> values) {
        this.keyCd = keyCd;
        this.keyNm = KeyNm;
        this.values = values;
    }

}