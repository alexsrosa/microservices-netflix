package com.architecture.microservices.estudanteservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties
public class EstudanteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EstudanteServiceApplication.class, args);
    }
}
