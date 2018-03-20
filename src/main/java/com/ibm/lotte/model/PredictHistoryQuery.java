package com.ibm.lotte.model;


import lombok.Data;

import java.io.Serializable;

@Data
public class PredictHistoryQuery implements Serializable {

    private String versionNo;

//    String createAt ;

    public PredictHistoryQuery() {
    }

    public PredictHistoryQuery(String versionNo) {
        this.versionNo = versionNo;
//        this.createAt = createAt;
    }

//    public Date getCreateAt() {
//        return DateUtils.parseDate( this.createAt );
//    }
}
