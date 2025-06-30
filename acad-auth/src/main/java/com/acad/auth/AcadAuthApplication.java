package com.acad.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AcadAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcadAuthApplication.class, args);
    }

}
