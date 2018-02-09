package com.ibm.lotte;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ibm.lotte.model.QueryResult;
import com.ibm.lotte.repository.PredictionRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class PredictProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(PredictProductApplication.class, args);
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

    @Bean
    public CommandLineRunner loadData(PredictionRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new QueryResult("0", "brand_nm0", "func_nm0", "maker_nm0", "mat_1_nm0", "mat_2_nm0", "mat_3_nm0", "mat_4_nm0", "mat_5_nm0", "mat_6_nm0", "prod_cat_2_nm0", "prod_cat_3_nm0", "taste_1_nm0", "taste_2_nm0", "taste_3_nm0", "txtre_1_nm0", "txtre_2_nm0", "txtre_3_nm0", "key_nm0", 10));
            repository.save(new QueryResult("1", "brand_nm1", "func_nm1", "maker_nm1", "mat_1_nm1", "mat_2_nm1", "mat_3_nm1", "mat_4_nm1", "mat_5_nm1", "mat_6_nm1", "prod_cat_2_nm1", "prod_cat_3_nm1", "taste_1_nm1", "taste_2_nm1", "taste_3_nm1", "txtre_1_nm1", "txtre_2_nm1", "txtre_3_nm1", "key_nm1", 101));
            repository.save(new QueryResult("2", "brand_nm2", "func_nm2", "maker_nm2", "mat_1_nm2", "mat_2_nm2", "mat_3_nm2", "mat_4_nm2", "mat_5_nm2", "mat_6_nm2", "prod_cat_2_nm2", "prod_cat_3_nm2", "taste_1_nm2", "taste_2_nm2", "taste_3_nm2", "txtre_1_nm2", "txtre_2_nm2", "txtre_3_nm2", "key_nm2", 102));
            repository.save(new QueryResult("3", "brand_nm3", "func_nm3", "maker_nm3", "mat_1_nm3", "mat_2_nm3", "mat_3_nm3", "mat_4_nm3", "mat_5_nm3", "mat_6_nm3", "prod_cat_2_nm3", "prod_cat_3_nm3", "taste_1_nm3", "taste_2_nm3", "taste_3_nm3", "txtre_1_nm3", "txtre_2_nm3", "txtre_3_nm3", "key_nm3", 103));
            repository.save(new QueryResult("4", "brand_nm4", "func_nm4", "maker_nm4", "mat_1_nm4", "mat_2_nm4", "mat_3_nm4", "mat_4_nm4", "mat_5_nm4", "mat_6_nm4", "prod_cat_2_nm4", "prod_cat_3_nm4", "taste_1_nm4", "taste_2_nm4", "taste_3_nm4", "txtre_1_nm4", "txtre_2_nm4", "txtre_3_nm4", "key_nm4", 104));
            repository.save(new QueryResult("5", "brand_nm5", "func_nm5", "maker_nm5", "mat_1_nm5", "mat_2_nm5", "mat_3_nm5", "mat_4_nm5", "mat_5_nm5", "mat_6_nm5", "prod_cat_2_nm5", "prod_cat_3_nm5", "taste_1_nm5", "taste_2_nm5", "taste_3_nm5", "txtre_1_nm5", "txtre_2_nm5", "txtre_3_nm5", "key_nm5", 105));
            repository.save(new QueryResult("6", "brand_nm6", "func_nm6", "maker_nm6", "mat_1_nm6", "mat_2_nm6", "mat_3_nm6", "mat_4_nm6", "mat_5_nm6", "mat_6_nm6", "prod_cat_2_nm6", "prod_cat_3_nm6", "taste_1_nm6", "taste_2_nm6", "taste_3_nm6", "txtre_1_nm6", "txtre_2_nm6", "txtre_3_nm6", "key_nm6", 106));
            repository.save(new QueryResult("7", "brand_nm7", "func_nm7", "maker_nm7", "mat_1_nm7", "mat_2_nm7", "mat_3_nm7", "mat_4_nm7", "mat_5_nm7", "mat_6_nm7", "prod_cat_2_nm7", "prod_cat_3_nm7", "taste_1_nm7", "taste_2_nm7", "taste_3_nm7", "txtre_1_nm7", "txtre_2_nm7", "txtre_3_nm7", "key_nm7", 107));
            repository.save(new QueryResult("8", "brand_nm8", "func_nm8", "maker_nm8", "mat_1_nm8", "mat_2_nm8", "mat_3_nm8", "mat_4_nm8", "mat_5_nm8", "mat_6_nm8", "prod_cat_2_nm8", "prod_cat_3_nm8", "taste_1_nm8", "taste_2_nm8", "taste_3_nm8", "txtre_1_nm8", "txtre_2_nm8", "txtre_3_nm8", "key_nm8", 108));
            repository.save(new QueryResult("9", "brand_nm9", "func_nm9", "maker_nm9", "mat_1_nm9", "mat_2_nm9", "mat_3_nm9", "mat_4_nm9", "mat_5_nm9", "mat_6_nm9", "prod_cat_2_nm9", "prod_cat_3_nm9", "taste_1_nm9", "taste_2_nm9", "taste_3_nm9", "txtre_1_nm9", "txtre_2_nm9", "txtre_3_nm9", "key_nm9", 109));

            // fetch all customers
            log.info("QueryResult found with findAll():");
            log.info("-------------------------------");
            for (QueryResult result : repository.findAll()) {
                log.info(result.toString());
            }
            log.info("");
        };
    }

}
