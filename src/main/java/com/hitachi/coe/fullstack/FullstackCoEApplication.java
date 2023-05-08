package com.hitachi.coe.fullstack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableScheduling
@EnableJpaAuditing
public class FullstackCoEApplication {

    public static void main(String[] args) {
        SpringApplication.run(FullstackCoEApplication.class);
    }
}