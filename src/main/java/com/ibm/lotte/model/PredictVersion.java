package com.ibm.lotte.model;

import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity(name="predict_ver")
@Data
public class PredictVersion {

    @Id
    @Column(name = "ver_no", nullable = false)
    String version;

    @Column(name = "description", nullable = false)
    String description;

    @Column(name = "url", nullable = false)
    String url;

    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "reg_dttm", nullable = false)
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
