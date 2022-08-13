package com.example.demo;

import com.example.demo.model.CompanyEntity;
import com.example.demo.repository.CompanyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
@EnableFeignClients
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner run(CompanyRepository companyRepository) {
		return args -> {
			companyRepository.save(new CompanyEntity(1, "Supra", 500, "IT", 1));
			companyRepository.save(new CompanyEntity(2, "Nextronics", 150, "Industry", 2));
		};
	}
}
