package com.horanghi.repository;

import com.horanghi.model.Attribute;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributeRepository extends CrudRepository<Attribute, Long> {

    List<Attribute> findByAttributeCategoryParentCode(String attributeCategoryParentCode);

    List<Attribute> findByAttributeCode(String attributeCode);

    List<Attribute> findByAttributeName(String attributeName);

    List<Attribute> findByAttributeCategoryCode(String category_code);

    List<Attribute> findByAttributeCategoryName(String category_name);

    List<Attribute> findAll();
}
