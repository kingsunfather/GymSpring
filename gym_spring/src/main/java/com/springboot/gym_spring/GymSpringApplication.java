package com.springboot.gym_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableCaching
public class GymSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(GymSpringApplication.class, args);
    }

}
