package com.ibm.lotte;

import com.ibm.lotte.model.Attribute;
import com.ibm.lotte.model.PredictModel;
import com.ibm.lotte.model.PredictVersion;
import com.ibm.lotte.repository.AttributeRepository;
import com.ibm.lotte.repository.PredictionRepository;
import com.ibm.lotte.repository.VersionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

    private void loadPredict() {
        // save a couple of customers
        repository.save( new PredictModel( "2017-01-01", false, "201806", "code1", "brand_nm01_func_nm01_maker_nm0_mat_1_nm0_mat_2_nm0_mat_3_nm0_mat_4_nm0_mat_5_nm0_mat_6_nm0_prod_cat_2_nm0_prod_cat_3_nm0_taste_1_nm0_taste_2_nm0_stritaste_3_nmng0_txtre_1_nm0_txtre_2_nm0_txtre_3_nm0", 30 ) );
        repository.save( new PredictModel( "2017-02-01", false, "201807", "code2", "brand_nm02_func_nm02_maker_nm0_mat_1_nm0_mat_2_nm0_mat_3_nm0_mat_4_nm0_mat_5_nm0_mat_6_nm0_prod_cat_2_nm0_prod_cat_3_nm0_taste_1_nm0_taste_2_nm0_stritaste_3_nmng0_txtre_1_nm0_txtre_2_nm0_txtre_3_nm0", 20 ) );
        repository.save( new PredictModel( "2017-03-01", false, "201808", "code3", "brand_nm03_func_nm03_maker_nm0_mat_1_nm0_mat_2_nm0_mat_3_nm0_mat_4_nm0_mat_5_nm0_mat_6_nm0_prod_cat_2_nm0_prod_cat_3_nm0_taste_1_nm0_taste_2_nm0_stritaste_3_nmng0_txtre_1_nm0_txtre_2_nm0_txtre_3_nm0", 10 ) );
        repository.save( new PredictModel( "2017-04-01", false, "201809", "code4", "brand_nm04_func_nm04_maker_nm0_mat_1_nm0_mat_2_nm0_mat_3_nm0_mat_4_nm0_mat_5_nm0_mat_6_nm0_prod_cat_2_nm0_prod_cat_3_nm0_taste_1_nm0_taste_2_nm0_stritaste_3_nmng0_txtre_1_nm0_txtre_2_nm0_txtre_3_nm0", 10 ) );
        repository.save( new PredictModel( "2017-05-01", false, "201810", "code5", "brand_nm05_func_nm05_maker_nm0_mat_1_nm0_mat_2_nm0_mat_3_nm0_mat_4_nm0_mat_5_nm0_mat_6_nm0_prod_cat_2_nm0_prod_cat_3_nm0_taste_1_nm0_taste_2_nm0_stritaste_3_nmng0_txtre_1_nm0_txtre_2_nm0_txtre_3_nm0", 15 ) );
        repository.save( new PredictModel( "2017-06-01", false, "201811", "code6", "brand_nm06_func_nm06_maker_nm0_mat_1_nm0_mat_2_nm0_mat_3_nm0_mat_4_nm0_mat_5_nm0_mat_6_nm0_prod_cat_2_nm0_prod_cat_3_nm0_taste_1_nm0_taste_2_nm0_stritaste_3_nmng0_txtre_1_nm0_txtre_2_nm0_txtre_3_nm0", 110 ) );
        repository.save( new PredictModel( "2017-07-01", false, "201806", "code7", "brand_nm07_func_nm07_maker_nm0_mat_1_nm0_mat_2_nm0_mat_3_nm0_mat_4_nm0_mat_5_nm0_mat_6_nm0_prod_cat_2_nm0_prod_cat_3_nm0_taste_1_nm0_taste_2_nm0_stritaste_3_nmng0_txtre_1_nm0_txtre_2_nm0_txtre_3_nm0", 10 ) );
        repository.save( new PredictModel( "2017-08-01", false, "201807", "code8", "brand_nm08_func_nm08_maker_nm0_mat_1_nm0_mat_2_nm0_mat_3_nm0_mat_4_nm0_mat_5_nm0_mat_6_nm0_prod_cat_2_nm0_prod_cat_3_nm0_taste_1_nm0_taste_2_nm0_stritaste_3_nmng0_txtre_1_nm0_txtre_2_nm0_txtre_3_nm0", 10 ) );
        repository.save( new PredictModel( "2017-09-01", false, "201808", "code9", "brand_nm09_func_nm09_maker_nm0_mat_1_nm0_mat_2_nm0_mat_3_nm0_mat_4_nm0_mat_5_nm0_mat_6_nm0_prod_cat_2_nm0_prod_cat_3_nm0_taste_1_nm0_taste_2_nm0_stritaste_3_nmng0_txtre_1_nm0_txtre_2_nm0_txtre_3_nm0", 10 ) );
        repository.save( new PredictModel( "2017-10-01", false, "201809", "code10", "brand_nm10_func_nm10_maker_nm0_mat_1_nm0_mat_2_nm0_mat_3_nm0_mat_4_nm0_mat_5_nm0_mat_6_nm0_prod_cat_2_nm0_prod_cat_3_nm0_taste_1_nm0_taste_2_nm0_stritaste_3_nmng0_txtre_1_nm0_txtre_2_nm0_txtre_3_nm0", 110 ) );
        repository.save( new PredictModel( "2017-11-01", false, "201810", "code11", "brand_nm11_func_nm11_maker_nm0_mat_1_nm0_mat_2_nm0_mat_3_nm0_mat_4_nm0_mat_5_nm0_mat_6_nm0_prod_cat_2_nm0_prod_cat_3_nm0_taste_1_nm0_taste_2_nm0_stritaste_3_nmng0_txtre_1_nm0_txtre_2_nm0_txtre_3_nm0", 14440 ) );
        repository.save( new PredictModel( "2017-12-01", false, "201811", "code12", "brand_nm12_func_nm12_maker_nm0_mat_1_nm0_mat_2_nm0_mat_3_nm0_mat_4_nm0_mat_5_nm0_mat_6_nm0_prod_cat_2_nm0_prod_cat_3_nm0_taste_1_nm0_taste_2_nm0_stritaste_3_nmng0_txtre_1_nm0_txtre_2_nm0_txtre_3_nm0", 10 ) );

        versionRepository.save( new PredictVersion( "2017-01-01", "description201701", "http://localhost:8080/predit" ) );
        versionRepository.save( new PredictVersion( "2017-02-01", "description201702", "http://localhost:8080/predit" ) );
        versionRepository.save( new PredictVersion( "2017-03-01", "description201703", "http://localhost:8080/predit" ) );
        versionRepository.save( new PredictVersion( "2017-04-01", "description201704", "http://localhost:8080/predit" ) );
        versionRepository.save( new PredictVersion( "2017-05-01", "description201705", "http://localhost:8080/predit" ) );
        versionRepository.save( new PredictVersion( "2017-06-01", "description201706", "http://localhost:8080/predit" ) );
        versionRepository.save( new PredictVersion( "2017-07-01", "description201707", "http://localhost:8080/predit" ) );
        versionRepository.save( new PredictVersion( "2017-08-01", "description201708", "http://localhost:8080/predit" ) );
        versionRepository.save( new PredictVersion( "2017-09-01", "description201709", "http://localhost:8080/predit" ) );
        versionRepository.save( new PredictVersion( "2017-10-01", "description201710", "http://localhost:8080/predit" ) );
        versionRepository.save( new PredictVersion( "2017-11-01", "description201711", "http://localhost:8080/predit" ) );
        versionRepository.save( new PredictVersion( "2017-12-01", "description201712", "http://localhost:8080/predit" ) );
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
        attributeRepository.save( new Attribute( "brand", "브랜드", "bc01", "빼빼로", "root" ) );
        attributeRepository.save( new Attribute( "brand", "브랜드", "bc02", "칸초", "root" ) );
        attributeRepository.save( new Attribute( "func", "기능", "fc01", "기호", "brand" ) );
        attributeRepository.save( new Attribute( "func", "기능", "fc02", "다이어트", "brand" ) );
        attributeRepository.save( new Attribute( "mat", "식재료", "mat01", "초콜릿", "func" ) );
        attributeRepository.save( new Attribute( "mat", "식재료", "mat02", "우유", "func" ) );
        attributeRepository.save( new Attribute( "mat", "식재료", "mat03", "밀가루", "func" ) );
        attributeRepository.save( new Attribute( "mat", "식재료", "mat04", "콩", "func" ) );
        attributeRepository.save( new Attribute( "mat", "식재료", "mat05", "옥수수", "func" ) );
        attributeRepository.save( new Attribute( "taste", "맛", "taste01", "구수하다", "mat" ) );
        attributeRepository.save( new Attribute( "taste", "맛", "taste02", "달콤하다", "mat" ) );
        attributeRepository.save( new Attribute( "taste", "맛", "taste03", "부드럽다", "mat" ) );
        for (Attribute attribute : attributeRepository.findAll()) {
            log.info( attribute.toString() );
        }

        for (Attribute attribute : attributeRepository.findByAttributeCategoryParentCode( "func" )) {
            log.info( attribute.toString() );
        }

    }

}
