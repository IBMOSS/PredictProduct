package com.ibm.lotte.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
public class PredictVersionQuery {

    String version;

    String description;

    String url;

    public PredictVersionQuery() {
    }

    public PredictVersionQuery(String version,
                               String description,
                               String url) {
        this.version = version;
        this.description = description;
        this.url = url;
    }

}
