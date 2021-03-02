package com.phani.devarapu.CRAPIGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CrapiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrapiGatewayApplication.class, args);
	}

}
