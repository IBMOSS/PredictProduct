package com.ibm.lotte.model;

import lombok.Data;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Data
public class PredictVersion {

    @Id
    String version;

    String description;

    String url;

    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    java.util.Date createAt;

    public PredictVersion() {
    }

    public PredictVersion(String version,
                          String description,
                          String url) {
        this.version = version;
        this.description = description;
        this.url = url;
        this.createAt = new Date();
    }


    public String getCreateAt() {
        SimpleDateFormat sdfDate = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        String strDate = sdfDate.format( this.createAt );
        return strDate;
    }

}
