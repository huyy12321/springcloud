package com.hyy.apollo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApolloApplication {

    public static void main(String[] args) {
        System.setProperty("env", "DEV");
        SpringApplication.run(ApolloApplication.class, args);
    }

}
