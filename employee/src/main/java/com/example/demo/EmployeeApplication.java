package com.example.demo;

import com.example.demo.model.EmployeeEntity;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableFeignClients
@EnableJpaAuditing
@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	@Bean
	CommandLineRunner run(EmployeeRepository employeeRepository) {
		return args -> {
			employeeRepository.save(new EmployeeEntity(1, "ahmed", "marouani", "ahmed.marouani@gmail.com", 27 , 800, 1));
			employeeRepository.save(new EmployeeEntity(2, "hathemi", "bensalem", "hathemi.bensalem@gmail.com", 22, 800, 2 ));
		};
	}

}
