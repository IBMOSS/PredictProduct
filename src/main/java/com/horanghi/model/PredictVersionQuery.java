package com.horanghi.model;

import lombok.Data;


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
