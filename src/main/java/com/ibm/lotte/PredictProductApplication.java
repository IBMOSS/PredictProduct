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
			repository.save(new QueryResult("1", "c_1_1", "r_1_1_1", 10));
			repository.save(new QueryResult("2", "c_1_2", "r_1_1_2", 11));
			repository.save(new QueryResult("3", "c_1_3", "r_1_1_3", 12));
			repository.save(new QueryResult("4", "c_1_4", "r_1_1_4", 13));

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
