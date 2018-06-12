package com.horanghi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class AttributeQuery {

    String attributeCategoryCode;

    String attributeCategoryName;

    String attributeCode;

    String attributeName;

    String attributeCategoryParentCode;

}
