package com.eknus.week05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:bean-definitions-context.xml")
public class Week05Application {

    public static void main(String[] args) {
        SpringApplication.run(Week05Application.class, args);
    }

}
