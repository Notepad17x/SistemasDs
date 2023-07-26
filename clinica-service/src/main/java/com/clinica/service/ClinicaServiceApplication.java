package com.clinica.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ClinicaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicaServiceApplication.class, args);
	}

}
