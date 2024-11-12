package com.launderup.LaunderUp_Backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories
public class LaunderUpBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaunderUpBackendApplication.class, args);
	}

}
