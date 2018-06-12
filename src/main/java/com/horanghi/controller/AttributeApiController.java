package com.horanghi.controller;

import com.horanghi.model.Attribute;
import com.horanghi.repository.AttributeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/attribute")
@Slf4j
public class AttributeApiController {


    @Autowired
    AttributeRepository attributeRepository;

    @RequestMapping(value = "/parentcode/{parent_attribute_code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    List<Attribute> findAttributes(@PathVariable String parent_attribute_code) {
        return attributeRepository.findByAttributeCategoryParentCode(parent_attribute_code);
    }

    @RequestMapping(value = "/categorycode/{category_code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    List<Attribute> findByCategoryCode(@PathVariable String category_code) {
        return attributeRepository.findByAttributeCategoryCode(category_code);
    }

    @RequestMapping(value = "/categoryname/{category_name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    List<Attribute> findByCategoryName(@PathVariable String category_name) {
        return attributeRepository.findByAttributeCategoryName(category_name);
    }

    @RequestMapping(value = "/attributecode/{attribute_code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    List<Attribute> findByCode(@PathVariable String attribute_code) {
        return attributeRepository.findByAttributeCode(attribute_code);
    }

    @RequestMapping(value = "/attributename/{attribute_name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    List<Attribute> findByName(@PathVariable String attribute_name) {
        return attributeRepository.findByAttributeName(attribute_name);
    }
}
