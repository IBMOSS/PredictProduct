package com.ibm.lotte;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.lotte.model.Attribute;
import com.ibm.lotte.model.PredictModel;
import com.ibm.lotte.model.PredictVersion;
import com.ibm.lotte.model.Sim;
import com.ibm.lotte.repository.AttributeRepository;
import com.ibm.lotte.repository.PredictionRepository;
import com.ibm.lotte.repository.VersionRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

import javax.persistence.Id;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Long.valueOf;

@SpringBootApplication
@Slf4j
public class PredictProductApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run( PredictProductApplication.class, args );
    }

    @Autowired
    PredictionRepository repository;
    @Autowired
    VersionRepository versionRepository;
    @Autowired
    AttributeRepository attributeRepository;

    @Override
    public void run(String... args) throws Exception {
        loadPredict();
        loadAttribute();
    }


    private void loadPredict() throws JsonProcessingException {

        if (!repository.findAll().isEmpty()) {
            return;
        }

        ObjectMapper mapper = new ObjectMapper();
        String sim = mapper.writeValueAsString( new Sim( "simcd", "simnm", Arrays.asList( 0.0f, 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f ) ) );
        // save a couple of customers
        repository.save( new PredictModel( "2017-01-01", false,
                "brand_cd01_func_cd01_maker_cd01_mat_cd01_mat_cd02_mat_cd03_mat_cd04_mat_cd05_mat_cd06_prod_cat_cd01_prod_cat_cd02_taste_cd01_taste_cd02_taste_cd03_txtre_cd01_txtre_cd02_txtre_cd03",
                "brand_nm01_func_nm01_maker_nm01_mat_nm01_mat_nm02_mat_nm03_mat_nm04_mat_nm05_mat_nm06_prod_cat_nm01_prod_cat_nm02_taste_nm01_taste_nm02_taste_nm03_txtre_nm01_txtre_nm02_txtre_nm03",
                130, "0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0", sim, sim, sim, sim, sim ) );

        repository.save( new PredictModel( "2017-02-01", false,
                "brand_cd02_func_cd01_maker_cd01_mat_cd01_mat_cd02_mat_cd03_mat_cd04_mat_cd05_mat_cd06_prod_cat_cd01_prod_cat_cd02_taste_cd01_taste_cd02_taste_cd03_txtre_cd01_txtre_cd02_txtre_cd03",
                "brand_nm02_func_nm01_maker_nm01_mat_nm01_mat_nm02_mat_nm03_mat_nm04_mat_nm05_mat_nm06_prod_cat_nm01_prod_cat_nm02_taste_nm01_taste_nm02_taste_nm03_txtre_nm01_txtre_nm02_txtre_nm03",
                1301, "0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0", sim, sim, sim, sim, sim ) );
        repository.save( new PredictModel( "2017-01-01", false,
                "brand_cd01_func_cd01_maker_cd01_mat_cd01_mat_cd02_mat_cd03_mat_cd04_mat_cd05_mat_cd06_prod_cat_cd01_prod_cat_cd02_taste_cd01_taste_cd02_taste_cd03_txtre_cd01_txtre_cd02_txtre_cd03",
                "brand_nm01_func_nm01_maker_nm01_mat_nm01_mat_nm02_mat_nm03_mat_nm04_mat_nm05_mat_nm06_prod_cat_nm01_prod_cat_nm02_taste_nm01_taste_nm02_taste_nm03_txtre_nm01_txtre_nm02_txtre_nm03",
                1302, "0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0", sim, sim, sim, sim, sim ) );
        repository.save( new PredictModel( "2017-03-01", false,
                "brand_cd03_func_cd01_maker_cd01_mat_cd01_mat_cd02_mat_cd03_mat_cd04_mat_cd05_mat_cd06_prod_cat_cd01_prod_cat_cd02_taste_cd01_taste_cd02_taste_cd03_txtre_cd01_txtre_cd02_txtre_cd03",
                "brand_nm03_func_nm01_maker_nm01_mat_nm01_mat_nm02_mat_nm03_mat_nm04_mat_nm05_mat_nm06_prod_cat_nm01_prod_cat_nm02_taste_nm01_taste_nm02_taste_nm03_txtre_nm01_txtre_nm02_txtre_nm03",
                1303, "0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0", sim, sim, sim, sim, sim ) );
        repository.save( new PredictModel( "2017-04-01", false,
                "brand_cd04_func_cd01_maker_cd01_mat_cd01_mat_cd02_mat_cd03_mat_cd04_mat_cd05_mat_cd06_prod_cat_cd01_prod_cat_cd02_taste_cd01_taste_cd02_taste_cd03_txtre_cd01_txtre_cd02_txtre_cd03",
                "brand_nm04_func_nm01_maker_nm01_mat_nm01_mat_nm02_mat_nm03_mat_nm04_mat_nm05_mat_nm06_prod_cat_nm01_prod_cat_nm02_taste_nm01_taste_nm02_taste_nm03_txtre_nm01_txtre_nm02_txtre_nm03",
                130, "0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0", sim, sim, sim, sim, sim ) );
        repository.save( new PredictModel( "2017-05-01", false,
                "brand_cd05_func_cd01_maker_cd01_mat_cd01_mat_cd02_mat_cd03_mat_cd04_mat_cd05_mat_cd06_prod_cat_cd01_prod_cat_cd02_taste_cd01_taste_cd02_taste_cd03_txtre_cd01_txtre_cd02_txtre_cd03",
                "brand_nm05_func_nm01_maker_nm01_mat_nm01_mat_nm02_mat_nm03_mat_nm04_mat_nm05_mat_nm06_prod_cat_nm01_prod_cat_nm02_taste_nm01_taste_nm02_taste_nm03_txtre_nm01_txtre_nm02_txtre_nm03",
                1305, "0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0", sim, sim, sim, sim, sim ) );
        repository.save( new PredictModel( "2017-06-01", false,
                "brand_cd06_func_cd01_maker_cd01_mat_cd01_mat_cd02_mat_cd03_mat_cd04_mat_cd05_mat_cd06_prod_cat_cd01_prod_cat_cd02_taste_cd01_taste_cd02_taste_cd03_txtre_cd01_txtre_cd02_txtre_cd03",
                "brand_nm06_func_nm01_maker_nm01_mat_nm01_mat_nm02_mat_nm03_mat_nm04_mat_nm05_mat_nm06_prod_cat_nm01_prod_cat_nm02_taste_nm01_taste_nm02_taste_nm03_txtre_nm01_txtre_nm02_txtre_nm03",
                1306, "0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0", sim, sim, sim, sim, sim ) );
        repository.save( new PredictModel( "2017-07-01", false,
                "brand_cd07_func_cd01_maker_cd01_mat_cd01_mat_cd02_mat_cd03_mat_cd04_mat_cd05_mat_cd06_prod_cat_cd01_prod_cat_cd02_taste_cd01_taste_cd02_taste_cd03_txtre_cd01_txtre_cd02_txtre_cd03",
                "brand_nm07_func_nm01_maker_nm01_mat_nm01_mat_nm02_mat_nm03_mat_nm04_mat_nm05_mat_nm06_prod_cat_nm01_prod_cat_nm02_taste_nm01_taste_nm02_taste_nm03_txtre_nm01_txtre_nm02_txtre_nm03",
                1307, "0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0", sim, sim, sim, sim, sim ) );
        repository.save( new PredictModel( "2017-08-01", false,
                "brand_cd08_func_cd01_maker_cd01_mat_cd01_mat_cd02_mat_cd03_mat_cd04_mat_cd05_mat_cd06_prod_cat_cd01_prod_cat_cd02_taste_cd01_taste_cd02_taste_cd03_txtre_cd01_txtre_cd02_txtre_cd03",
                "brand_nm08_func_nm01_maker_nm01_mat_nm01_mat_nm02_mat_nm03_mat_nm04_mat_nm05_mat_nm06_prod_cat_nm01_prod_cat_nm02_taste_nm01_taste_nm02_taste_nm03_txtre_nm01_txtre_nm02_txtre_nm03",
                1308, "0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0", sim, sim, sim, sim, sim ) );
        repository.save( new PredictModel( "2017-09-01", false,
                "brand_cd09_func_cd01_maker_cd01_mat_cd01_mat_cd02_mat_cd03_mat_cd04_mat_cd05_mat_cd06_prod_cat_cd01_prod_cat_cd02_taste_cd01_taste_cd02_taste_cd03_txtre_cd01_txtre_cd02_txtre_cd03",
                "brand_nm09_func_nm01_maker_nm01_mat_nm01_mat_nm02_mat_nm03_mat_nm04_mat_nm05_mat_nm06_prod_cat_nm01_prod_cat_nm02_taste_nm01_taste_nm02_taste_nm03_txtre_nm01_txtre_nm02_txtre_nm03",
                1301, "0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0", sim, sim, sim, sim, sim ) );
        repository.save( new PredictModel( "2017-010-01", false,
                "brand_cd010_func_cd01_maker_cd01_mat_cd01_mat_cd02_mat_cd03_mat_cd04_mat_cd05_mat_cd06_prod_cat_cd01_prod_cat_cd02_taste_cd01_taste_cd02_taste_cd03_txtre_cd01_txtre_cd02_txtre_cd03",
                "brand_nm010_func_nm01_maker_nm01_mat_nm01_mat_nm02_mat_nm03_mat_nm04_mat_nm05_mat_nm06_prod_cat_nm01_prod_cat_nm02_taste_nm01_taste_nm02_taste_nm03_txtre_nm01_txtre_nm02_txtre_nm03",
                1300, "0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0", sim, sim, sim, sim, sim ) );
//        repository.save( new PredictModel( "2017-02-01", false,
//                "brand_cd02_func_cd01_maker_cd01_mat_cd01_mat_cd02_mat_cd03_mat_cd04_mat_cd05_mat_cd06_prod_cat_cd01_prod_cat_cd02_taste_cd01_taste_cd02_taste_cd03_txtre_cd01_txtre_cd02_txtre_cd03",
//                "brand_nm02_func_nm01_maker_nm01_mat_nm01_mat_nm02_mat_nm03_mat_nm04_mat_nm05_mat_nm06_prod_cat_nm01_prod_cat_nm02_taste_nm01_taste_nm02_taste_nm03_txtre_nm01_txtre_nm02_txtre_nm03",
//                 230, " [ 0,1,2,3,4,5,6,7 ] ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } " ) );
//        ;
//        repository.save( new PredictModel( "2017-03-01", false,
//                "brand_cd03_func_cd01_maker_cd01_mat_cd01_mat_cd02_mat_cd03_mat_cd04_mat_cd05_mat_cd06_prod_cat_cd01_prod_cat_cd02_taste_cd01_taste_cd02_taste_cd03_txtre_cd01_txtre_cd02_txtre_cd03",
//                "brand_nm03_func_nm01_maker_nm01_mat_nm01_mat_nm02_mat_nm03_mat_nm04_mat_nm05_mat_nm06_prod_cat_nm01_prod_cat_nm02_taste_nm01_taste_nm02_taste_nm03_txtre_nm01_txtre_nm02_txtre_nm03",
//                 330, " [ 0,1,2,3,4,5,6,7 ] ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } " ) );
//        ;
//        repository.save( new PredictModel( "2017-04-01", false,
//                "brand_cd04_func_cd01_maker_cd01_mat_cd01_mat_cd02_mat_cd03_mat_cd04_mat_cd05_mat_cd06_prod_cat_cd01_prod_cat_cd02_taste_cd01_taste_cd02_taste_cd03_txtre_cd01_txtre_cd02_txtre_cd03",
//                "brand_nm04_func_nm01_maker_nm01_mat_nm01_mat_nm02_mat_nm03_mat_nm04_mat_nm05_mat_nm06_prod_cat_nm01_prod_cat_nm02_taste_nm01_taste_nm02_taste_nm03_txtre_nm01_txtre_nm02_txtre_nm03",
//                 430, " [ 0,1,2,3,4,5,6,7 ] ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } " ) );
//        ;
//        repository.save( new PredictModel( "2017-05-01", false,
//                "brand_cd05_func_cd01_maker_cd01_mat_cd01_mat_cd02_mat_cd03_mat_cd04_mat_cd05_mat_cd06_prod_cat_cd01_prod_cat_cd02_taste_cd01_taste_cd02_taste_cd03_txtre_cd01_txtre_cd02_txtre_cd03",
//                "brand_nm05_func_nm01_maker_nm01_mat_nm01_mat_nm02_mat_nm03_mat_nm04_mat_nm05_mat_nm06_prod_cat_nm01_prod_cat_nm02_taste_nm01_taste_nm02_taste_nm03_txtre_nm01_txtre_nm02_txtre_nm03",
//                 630, " [ 0,1,2,3,4,5,6,7 ] ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } " ) );
//        ;
//        repository.save( new PredictModel( "2017-06-01", false,
//                "brand_cd06_func_cd01_maker_cd01_mat_cd01_mat_cd02_mat_cd03_mat_cd04_mat_cd05_mat_cd06_prod_cat_cd01_prod_cat_cd02_taste_cd01_taste_cd02_taste_cd03_txtre_cd01_txtre_cd02_txtre_cd03",
//                "brand_nm06_func_nm01_maker_nm01_mat_nm01_mat_nm02_mat_nm03_mat_nm04_mat_nm05_mat_nm06_prod_cat_nm01_prod_cat_nm02_taste_nm01_taste_nm02_taste_nm03_txtre_nm01_txtre_nm02_txtre_nm03",
//                 30, " [ 0,1,2,3,4,5,6,7 ] ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } " ) );
//        ;
//        repository.save( new PredictModel( "2017-07-01", false,
//                "brand_cd07_func_cd01_maker_cd01_mat_cd01_mat_cd02_mat_cd03_mat_cd04_mat_cd05_mat_cd06_prod_cat_cd01_prod_cat_cd02_taste_cd01_taste_cd02_taste_cd03_txtre_cd01_txtre_cd02_txtre_cd03",
//                "brand_nm07_func_nm01_maker_nm01_mat_nm01_mat_nm02_mat_nm03_mat_nm04_mat_nm05_mat_nm06_prod_cat_nm01_prod_cat_nm02_taste_nm01_taste_nm02_taste_nm03_txtre_nm01_txtre_nm02_txtre_nm03",
//                 330, " [ 0,1,2,3,4,5,6,7 ] ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } " ) );
//
//        repository.save( new PredictModel( "2017-08-01", false,
//                "brand_cd08_func_cd01_maker_cd01_mat_cd01_mat_cd02_mat_cd03_mat_cd04_mat_cd05_mat_cd06_prod_cat_cd01_prod_cat_cd02_taste_cd01_taste_cd02_taste_cd03_txtre_cd01_txtre_cd02_txtre_cd03",
//                "brand_nm08_func_nm01_maker_nm01_mat_nm01_mat_nm02_mat_nm03_mat_nm04_mat_nm05_mat_nm06_prod_cat_nm01_prod_cat_nm02_taste_nm01_taste_nm02_taste_nm03_txtre_nm01_txtre_nm02_txtre_nm03",
//                 330, " [ 0,1,2,3,4,5,6,7 ] ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } " ) );
//
//        repository.save( new PredictModel( "2017-09-01", false,
//                "brand_cd09_func_cd01_maker_cd01_mat_cd01_mat_cd02_mat_cd03_mat_cd04_mat_cd05_mat_cd06_prod_cat_cd01_prod_cat_cd02_taste_cd01_taste_cd02_taste_cd03_txtre_cd01_txtre_cd02_txtre_cd03",
//                "brand_nm09_func_nm01_maker_nm01_mat_nm01_mat_nm02_mat_nm03_mat_nm04_mat_nm05_mat_nm06_prod_cat_nm01_prod_cat_nm02_taste_nm01_taste_nm02_taste_nm03_txtre_nm01_txtre_nm02_txtre_nm03",
//                 330, " [ 0,1,2,3,4,5,6,7 ] ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } ",
//                " { \"key_cd\" : \"simcd\" , \"key_nm\" : \"simnm\" , \"values\" :  [ 0,1,2,3,4,5,6,7 ] } " ) );


        versionRepository.save( new PredictVersion( "2017-01-01", "description201701", "http://localhost:8080/predit" ) );
        versionRepository.save( new PredictVersion( "2017-02-01", "description201702", "http://localhost:8080/predit" ) );
        versionRepository.save( new PredictVersion( "2017-03-01", "description201703", "http://localhost:8080/predit" ) );
        versionRepository.save( new PredictVersion( "2017-04-01", "description201704", "http://localhost:8080/predit" ) );
        versionRepository.save( new PredictVersion( "2017-05-01", "description201705", "http://localhost:8080/predit" ) );
        versionRepository.save( new PredictVersion( "2017-06-01", "description201706", "http://localhost:8080/predit" ) );
        versionRepository.save( new PredictVersion( "2017-07-01", "description201707", "http://localhost:8080/predit" ) );
        versionRepository.save( new PredictVersion( "2017-08-01", "description201708", "http://localhost:8080/predit" ) );
        versionRepository.save( new PredictVersion( "2017-09-01", "description201709", "http://localhost:8080/predit" ) );

        // fetch all customers
        log.info( "QueryResult found with findAll():" );
        log.info( "-------------------------------" );
        for (PredictModel result : repository.findAll()) {
            log.info( result.toString() );
        }
        for (PredictVersion result : versionRepository.findAll()) {
            log.info( result.toString() );
        }
        log.info( "" );
    }

    private void loadAttribute() {
        if (!attributeRepository.findAll().isEmpty()) {
            return;
        }
        attributeRepository.save( new Attribute( "brand_cd", "브랜드", "brand_cd01", "brand_nm01", "root" ) );
        attributeRepository.save( new Attribute( "brand_cd", "브랜드", "brand_cd02", "brand_nm02", "root" ) );
        attributeRepository.save( new Attribute( "brand_cd", "브랜드", "brand_cd03", "brand_nm03", "root" ) );
        attributeRepository.save( new Attribute( "brand_cd", "브랜드", "brand_cd04", "brand_nm04", "root" ) );
        attributeRepository.save( new Attribute( "brand_cd", "브랜드", "brand_cd05", "brand_nm05", "root" ) );
        attributeRepository.save( new Attribute( "brand_cd", "브랜드", "brand_cd06", "brand_nm06", "root" ) );
        attributeRepository.save( new Attribute( "brand_cd", "브랜드", "brand_cd07", "brand_nm07", "root" ) );
        attributeRepository.save( new Attribute( "brand_cd", "브랜드", "brand_cd08", "brand_nm08", "root" ) );
        attributeRepository.save( new Attribute( "brand_cd", "브랜드", "brand_cd09", "brand_nm09", "root" ) );
        attributeRepository.save( new Attribute( "func_cd", "기능", "func_cd01", "func_nm01", "brand_cd" ) );
        attributeRepository.save( new Attribute( "func_cd", "기능", "func_cd02", "func_nm02", "brand_cd" ) );
        attributeRepository.save( new Attribute( "func_cd", "기능", "func_cd03", "func_nm03", "brand_cd" ) );
        attributeRepository.save( new Attribute( "func_cd", "기능", "func_cd04", "func_nm04", "brand_cd" ) );
        attributeRepository.save( new Attribute( "func_cd", "기능", "func_cd05", "func_nm05", "brand_cd" ) );
        attributeRepository.save( new Attribute( "func_cd", "기능", "func_cd06", "func_nm06", "brand_cd" ) );
        attributeRepository.save( new Attribute( "func_cd", "기능", "func_cd07", "func_nm07", "brand_cd" ) );
        attributeRepository.save( new Attribute( "func_cd", "기능", "func_cd08", "func_nm08", "brand_cd" ) );
        attributeRepository.save( new Attribute( "func_cd", "기능", "func_cd09", "func_nm09", "brand_cd" ) );
        attributeRepository.save( new Attribute( "maker_cd", "메이커", "maker_cd01", "maker_nm01", "func_cd" ) );
        attributeRepository.save( new Attribute( "maker_cd", "메이커", "maker_cd02", "maker_nm02", "func_cd" ) );
        attributeRepository.save( new Attribute( "maker_cd", "메이커", "maker_cd03", "maker_nm03", "func_cd" ) );
        attributeRepository.save( new Attribute( "maker_cd", "메이커", "maker_cd04", "maker_nm04", "func_cd" ) );
        attributeRepository.save( new Attribute( "maker_cd", "메이커", "maker_cd05", "maker_nm05", "func_cd" ) );
        attributeRepository.save( new Attribute( "maker_cd", "메이커", "maker_cd06", "maker_nm06", "func_cd" ) );
        attributeRepository.save( new Attribute( "maker_cd", "메이커", "maker_cd07", "maker_nm07", "func_cd" ) );
        attributeRepository.save( new Attribute( "maker_cd", "메이커", "maker_cd08", "maker_nm08", "func_cd" ) );
        attributeRepository.save( new Attribute( "maker_cd", "메이커", "maker_cd09", "maker_nm09", "func_cd" ) );
        attributeRepository.save( new Attribute( "mat_cd", "재료", "mat_cd01", "mat_nm01", "maker_cd" ) );
        attributeRepository.save( new Attribute( "mat_cd", "재료", "mat_cd02", "mat_nm02", "maker_cd" ) );
        attributeRepository.save( new Attribute( "mat_cd", "재료", "mat_cd03", "mat_nm03", "maker_cd" ) );
        attributeRepository.save( new Attribute( "mat_cd", "재료", "mat_cd04", "mat_nm04", "maker_cd" ) );
        attributeRepository.save( new Attribute( "mat_cd", "재료", "mat_cd05", "mat_nm05", "maker_cd" ) );
        attributeRepository.save( new Attribute( "mat_cd", "재료", "mat_cd06", "mat_nm06", "maker_cd" ) );
        attributeRepository.save( new Attribute( "mat_cd", "재료", "mat_cd07", "mat_nm07", "maker_cd" ) );
        attributeRepository.save( new Attribute( "mat_cd", "재료", "mat_cd08", "mat_nm08", "maker_cd" ) );
        attributeRepository.save( new Attribute( "mat_cd", "재료", "mat_cd09", "mat_nm09", "maker_cd" ) );
        attributeRepository.save( new Attribute( "prod_cat_cd", "카테고리", "prod_cat_cd01", "prod_cat_nm01", "mat_cd" ) );
        attributeRepository.save( new Attribute( "prod_cat_cd", "카테고리", "prod_cat_cd02", "prod_cat_nm02", "mat_cd" ) );
        attributeRepository.save( new Attribute( "prod_cat_cd", "카테고리", "prod_cat_cd03", "prod_cat_nm03", "mat_cd" ) );
        attributeRepository.save( new Attribute( "prod_cat_cd", "카테고리", "prod_cat_cd04", "prod_cat_nm04", "mat_cd" ) );
        attributeRepository.save( new Attribute( "prod_cat_cd", "카테고리", "prod_cat_cd05", "prod_cat_nm05", "mat_cd" ) );
        attributeRepository.save( new Attribute( "prod_cat_cd", "카테고리", "prod_cat_cd06", "prod_cat_nm06", "mat_cd" ) );
        attributeRepository.save( new Attribute( "prod_cat_cd", "카테고리", "prod_cat_cd07", "prod_cat_nm07", "mat_cd" ) );
        attributeRepository.save( new Attribute( "prod_cat_cd", "카테고리", "prod_cat_cd08", "prod_cat_nm08", "mat_cd" ) );
        attributeRepository.save( new Attribute( "prod_cat_cd", "카테고리", "prod_cat_cd09", "prod_cat_nm09", "mat_cd" ) );
        attributeRepository.save( new Attribute( "taste_cd", "맛", "taste_cd01", "taste_nm01", "prod_cat_cd" ) );
        attributeRepository.save( new Attribute( "taste_cd", "맛", "taste_cd02", "taste_nm02", "prod_cat_cd" ) );
        attributeRepository.save( new Attribute( "taste_cd", "맛", "taste_cd03", "taste_nm03", "prod_cat_cd" ) );
        attributeRepository.save( new Attribute( "taste_cd", "맛", "taste_cd04", "taste_nm04", "prod_cat_cd" ) );
        attributeRepository.save( new Attribute( "taste_cd", "맛", "taste_cd05", "taste_nm05", "prod_cat_cd" ) );
        attributeRepository.save( new Attribute( "taste_cd", "맛", "taste_cd06", "taste_nm06", "prod_cat_cd" ) );
        attributeRepository.save( new Attribute( "taste_cd", "맛", "taste_cd07", "taste_nm07", "prod_cat_cd" ) );
        attributeRepository.save( new Attribute( "taste_cd", "맛", "taste_cd08", "taste_nm08", "prod_cat_cd" ) );
        attributeRepository.save( new Attribute( "taste_cd", "맛", "taste_cd09", "taste_nm09", "prod_cat_cd" ) );
        attributeRepository.save( new Attribute( "txtre_cd", "기타", "txtre_cd01", "txtre_nm01", "taste_cd" ) );
        attributeRepository.save( new Attribute( "txtre_cd", "기타", "txtre_cd02", "txtre_nm02", "taste_cd" ) );
        attributeRepository.save( new Attribute( "txtre_cd", "기타", "txtre_cd03", "txtre_nm03", "taste_cd" ) );
        attributeRepository.save( new Attribute( "txtre_cd", "기타", "txtre_cd04", "txtre_nm04", "taste_cd" ) );
        attributeRepository.save( new Attribute( "txtre_cd", "기타", "txtre_cd05", "txtre_nm05", "taste_cd" ) );
        attributeRepository.save( new Attribute( "txtre_cd", "기타", "txtre_cd06", "txtre_nm06", "taste_cd" ) );
        attributeRepository.save( new Attribute( "txtre_cd", "기타", "txtre_cd07", "txtre_nm07", "taste_cd" ) );
        attributeRepository.save( new Attribute( "txtre_cd", "기타", "txtre_cd08", "txtre_nm08", "taste_cd" ) );
        attributeRepository.save( new Attribute( "txtre_cd", "기타", "txtre_cd09", "txtre_nm09", "taste_cd" ) );

        for (Attribute attribute : attributeRepository.findAll()) {
            log.info( attribute.toString() );
        }

        for (Attribute attribute : attributeRepository.findByAttributeCategoryParentCode( "func" )) {
            log.info( attribute.toString() );
        }

    }

}

