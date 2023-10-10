package com.program927.facilityservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableCaching
@EnableTransactionManagement
@EnableAsync
public class FacilityServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FacilityServiceApplication.class, args);
    }
}
