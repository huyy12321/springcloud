package com.hyy.eurekaclientarticleeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author hyy
 * EnableHystrixDashboard  开启可视化监控
 * EnableTurbine 集群监控
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
@EnableTurbine
@EnableFeignClients(basePackages = "com.hyy.eurekaclientarticleeservice.controller")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}