package com.ibm.lotte.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode
public class AttributeQuery {

    String attributeCategoryCode;

    String attributeCategoryName;

    String attributeCode;

    String attributeName;

    String attributeCategoryParentCode;

}
