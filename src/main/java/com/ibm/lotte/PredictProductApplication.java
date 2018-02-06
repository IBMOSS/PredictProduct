package com.ibm.lotte;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ibm.lotte.model.Contact;
import com.ibm.lotte.service.impl.ContactRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class PredictProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(PredictProductApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(ContactRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Contact("Jack", "Bauer", "1", "1"));
			repository.save(new Contact("Chloe", "O'Brian", "1", "1"));
			repository.save(new Contact("Kim", "Bauer", "1", "1"));
			repository.save(new Contact("David", "Palmer", "1", "1"));
			repository.save(new Contact("Michelle", "Dessler", "1", "1"));

			// fetch all customers
			log.info("Contact found with findAll():");
			log.info("-------------------------------");
			for (Contact contact : repository.findAll()) {
				log.info(contact.toString());
			}
			log.info("");
		};
	}

}
