package com.eshopper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EShopperApplication {

	public static void main(String[] args) {
		SpringApplication.run(EShopperApplication.class, args);
	}

}
