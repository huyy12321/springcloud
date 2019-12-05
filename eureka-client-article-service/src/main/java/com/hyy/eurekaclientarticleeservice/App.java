package com.hyy.eurekaclientarticleeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author hyy
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.hyy.eurekaclientarticleeservice.controller")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}