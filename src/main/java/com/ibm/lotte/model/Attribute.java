package com.ibm.lotte.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity (name="predict_attribute")// This tells Hibernate to make a table out of this class
@Data
@EqualsAndHashCode
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "attr_cat_cd", nullable = false)
    String attributeCategoryCode;

    @Column(name = "attr_cat_nm", nullable = false)
    String attributeCategoryName;

    @Column(name = "attr_cd", nullable = false)
    String attributeCode;

    @Column(name = "attr_nm", nullable = false)
    String attributeName;

    @Column(name = "attr_cat_par_cd", nullable = false)
    String attributeCategoryParentCode;

    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "reg_dttm", nullable = false)
    java.util.Date createAt;

    public Attribute() {
    }

    public Attribute(String attributeCategoryCode, String attributeCategoryName, String attributeCode, String attributeName, String attributeCategoryParentCode) {
        this.attributeCategoryCode = attributeCategoryCode;
        this.attributeCategoryName = attributeCategoryName;
        this.attributeCode = attributeCode;
        this.attributeName = attributeName;
        this.attributeCategoryParentCode = attributeCategoryParentCode;
        this.createAt = new Date();
    }

    public String getCreateAt() {
        SimpleDateFormat sdfDate = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        String strDate = sdfDate.format( this.createAt );
        return strDate;
    }
}
