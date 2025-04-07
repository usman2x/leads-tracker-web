package com.leads.practice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leads.practice.model.Lead;
import com.leads.practice.repository.LeadRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
	}

	@Bean
	CommandLineRunner loadLeadsFromJson(LeadRepository repo) {
		return args -> {
			if (repo.count() == 0) {
				ObjectMapper mapper = new ObjectMapper();
				InputStream inputStream = new ClassPathResource("leads.json").getInputStream();
				List<Lead> leads = mapper.readValue(inputStream, new TypeReference<>() {});
				repo.saveAll(leads);
				System.out.println("Seeded leads from JSON.");
			}
		};
	}

}
