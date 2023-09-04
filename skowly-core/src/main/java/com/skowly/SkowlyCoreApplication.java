package com.skowly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SkowlyCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkowlyCoreApplication.class, args);
	}

}