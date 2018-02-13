package com.ibm.lotte;

import com.ibm.lotte.model.PredictModel;
import com.ibm.lotte.model.PredictVersion;
import com.ibm.lotte.repository.PredictionRepository;
import com.ibm.lotte.repository.VersionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class PredictProductApplication {

    public static void main(String[] args) {
        SpringApplication.run( PredictProductApplication.class, args );
    }

    // @Bean
    // public CommandLineRunner loadData(ContactRepository repository) {
    // return (args) -> {
    // // save a couple of customers
    // repository.save(new Contact("Jack", "Bauer", "1", "1"));
    // repository.save(new Contact("Chloe", "O'Brian", "1", "1"));
    // repository.save(new Contact("Kim", "Bauer", "1", "1"));
    // repository.save(new Contact("David", "Palmer", "1", "1"));
    // repository.save(new Contact("Michelle", "Dessler", "1", "1"));
    //
    // // fetch all customers
    // log.info("Contact found with findAll():");
    // log.info("-------------------------------");
    // for (Contact contact : repository.findAll()) {
    // log.info(contact.toString());
    // }
    // log.info("");
    // };
    // }

    @Autowired
    PredictionRepository repository;
    @Autowired
    VersionRepository versionRepository;

    @Bean
    public CommandLineRunner loadData() {
        return (args) -> {
            // save a couple of customers
            repository.save( new PredictModel( "201701", "brand_nm01_func_nm01_maker_nm0_mat_1_nm0_mat_2_nm0_mat_3_nm0_mat_4_nm0_mat_5_nm0_mat_6_nm0_prod_cat_2_nm0_prod_cat_3_nm0_taste_1_nm0_taste_2_nm0_stritaste_3_nmng0_txtre_1_nm0_txtre_2_nm0_txtre_3_nm0", "brand_nm01_func_nm01_maker_nm0_mat_1_nm0_mat_2_nm0_mat_3_nm0_mat_4_nm0_mat_5_nm0_mat_6_nm0_prod_cat_2_nm0_prod_cat_3_nm0_taste_1_nm0_taste_2_nm0_stritaste_3_nmng0_txtre_1_nm0_txtre_2_nm0_txtre_3_nm0", 30 ) );
            repository.save( new PredictModel( "201702", "brand_nm02_func_nm02_maker_nm0_mat_1_nm0_mat_2_nm0_mat_3_nm0_mat_4_nm0_mat_5_nm0_mat_6_nm0_prod_cat_2_nm0_prod_cat_3_nm0_taste_1_nm0_taste_2_nm0_stritaste_3_nmng0_txtre_1_nm0_txtre_2_nm0_txtre_3_nm0", "key_nm02", 20 ) );
            repository.save( new PredictModel( "201703", "brand_nm03_func_nm03_maker_nm0_mat_1_nm0_mat_2_nm0_mat_3_nm0_mat_4_nm0_mat_5_nm0_mat_6_nm0_prod_cat_2_nm0_prod_cat_3_nm0_taste_1_nm0_taste_2_nm0_stritaste_3_nmng0_txtre_1_nm0_txtre_2_nm0_txtre_3_nm0", "key_nm03", 10 ) );
            repository.save( new PredictModel( "201704", "brand_nm04_func_nm04_maker_nm0_mat_1_nm0_mat_2_nm0_mat_3_nm0_mat_4_nm0_mat_5_nm0_mat_6_nm0_prod_cat_2_nm0_prod_cat_3_nm0_taste_1_nm0_taste_2_nm0_stritaste_3_nmng0_txtre_1_nm0_txtre_2_nm0_txtre_3_nm0", "key_nm04", 10 ) );
            repository.save( new PredictModel( "201705", "brand_nm05_func_nm05_maker_nm0_mat_1_nm0_mat_2_nm0_mat_3_nm0_mat_4_nm0_mat_5_nm0_mat_6_nm0_prod_cat_2_nm0_prod_cat_3_nm0_taste_1_nm0_taste_2_nm0_stritaste_3_nmng0_txtre_1_nm0_txtre_2_nm0_txtre_3_nm0", "key_nm05", 15 ) );
            repository.save( new PredictModel( "201706", "brand_nm06_func_nm06_maker_nm0_mat_1_nm0_mat_2_nm0_mat_3_nm0_mat_4_nm0_mat_5_nm0_mat_6_nm0_prod_cat_2_nm0_prod_cat_3_nm0_taste_1_nm0_taste_2_nm0_stritaste_3_nmng0_txtre_1_nm0_txtre_2_nm0_txtre_3_nm0", "key_nm06", 110 ) );
            repository.save( new PredictModel( "201707", "brand_nm07_func_nm07_maker_nm0_mat_1_nm0_mat_2_nm0_mat_3_nm0_mat_4_nm0_mat_5_nm0_mat_6_nm0_prod_cat_2_nm0_prod_cat_3_nm0_taste_1_nm0_taste_2_nm0_stritaste_3_nmng0_txtre_1_nm0_txtre_2_nm0_txtre_3_nm0", "key_nm07", 10 ) );
            repository.save( new PredictModel( "201708", "brand_nm08_func_nm08_maker_nm0_mat_1_nm0_mat_2_nm0_mat_3_nm0_mat_4_nm0_mat_5_nm0_mat_6_nm0_prod_cat_2_nm0_prod_cat_3_nm0_taste_1_nm0_taste_2_nm0_stritaste_3_nmng0_txtre_1_nm0_txtre_2_nm0_txtre_3_nm0", "brand_nm08_func_nm08_maker_nm0_mat_1_nm0_mat_2_nm0_mat_3_nm0_mat_4_nm0_mat_5_nm0_mat_6_nm0_prod_cat_2_nm0_prod_cat_3_nm0_taste_1_nm0_taste_2_nm0_stritaste_3_nmng0_txtre_1_nm0_txtre_2_nm0_txtre_3_nm0", 10 ) );
            repository.save( new PredictModel( "201709", "brand_nm09_func_nm09_maker_nm0_mat_1_nm0_mat_2_nm0_mat_3_nm0_mat_4_nm0_mat_5_nm0_mat_6_nm0_prod_cat_2_nm0_prod_cat_3_nm0_taste_1_nm0_taste_2_nm0_stritaste_3_nmng0_txtre_1_nm0_txtre_2_nm0_txtre_3_nm0", "brand_nm09_func_nm09_maker_nm0_mat_1_nm0_mat_2_nm0_mat_3_nm0_mat_4_nm0_mat_5_nm0_mat_6_nm0_prod_cat_2_nm0_prod_cat_3_nm0_taste_1_nm0_taste_2_nm0_stritaste_3_nmng0_txtre_1_nm0_txtre_2_nm0_txtre_3_nm0", 10 ) );
            repository.save( new PredictModel( "201710", "brand_nm10_func_nm10_maker_nm0_mat_1_nm0_mat_2_nm0_mat_3_nm0_mat_4_nm0_mat_5_nm0_mat_6_nm0_prod_cat_2_nm0_prod_cat_3_nm0_taste_1_nm0_taste_2_nm0_stritaste_3_nmng0_txtre_1_nm0_txtre_2_nm0_txtre_3_nm0", "key_nm10", 110 ) );
            repository.save( new PredictModel( "201711", "brand_nm11_func_nm11_maker_nm0_mat_1_nm0_mat_2_nm0_mat_3_nm0_mat_4_nm0_mat_5_nm0_mat_6_nm0_prod_cat_2_nm0_prod_cat_3_nm0_taste_1_nm0_taste_2_nm0_stritaste_3_nmng0_txtre_1_nm0_txtre_2_nm0_txtre_3_nm0", "key_nm11", 14440 ) );
            repository.save( new PredictModel( "201712", "brand_nm12_func_nm12_maker_nm0_mat_1_nm0_mat_2_nm0_mat_3_nm0_mat_4_nm0_mat_5_nm0_mat_6_nm0_prod_cat_2_nm0_prod_cat_3_nm0_taste_1_nm0_taste_2_nm0_stritaste_3_nmng0_txtre_1_nm0_txtre_2_nm0_txtre_3_nm0", "key_nm12", 10 ) );

            versionRepository.save( new PredictVersion( "201701", "description201701", "http://localhost:8080/predit" ) );
            versionRepository.save( new PredictVersion( "201702", "description201702", "http://localhost:8080/predit" ) );
            versionRepository.save( new PredictVersion( "201703", "description201703", "http://localhost:8080/predit" ) );
            versionRepository.save( new PredictVersion( "201704", "description201704", "http://localhost:8080/predit" ) );
            versionRepository.save( new PredictVersion( "201705", "description201705", "http://localhost:8080/predit" ) );
            versionRepository.save( new PredictVersion( "201706", "description201706", "http://localhost:8080/predit" ) );
            versionRepository.save( new PredictVersion( "201707", "description201707", "http://localhost:8080/predit" ) );
            versionRepository.save( new PredictVersion( "201708", "description201708", "http://localhost:8080/predit" ) );
            versionRepository.save( new PredictVersion( "201709", "description201709", "http://localhost:8080/predit" ) );
            versionRepository.save( new PredictVersion( "201710", "description201710", "http://localhost:8080/predit" ) );
            versionRepository.save( new PredictVersion( "201711", "description201711", "http://localhost:8080/predit" ) );
            versionRepository.save( new PredictVersion( "201712", "description201712", "http://localhost:8080/predit" ) );
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
        };
    }

}
