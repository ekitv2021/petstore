package com.itvedant.petstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties({FileStorageProperties.class})
public class PetstoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(PetstoreApplication.class, args);
	}

}
