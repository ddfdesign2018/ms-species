package com.ddfdesign.msspecies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsSpeciesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsSpeciesApplication.class, args);
	}
}
