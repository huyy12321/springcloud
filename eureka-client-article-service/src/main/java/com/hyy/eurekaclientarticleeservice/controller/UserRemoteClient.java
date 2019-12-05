package com.hyy.eurekaclientarticleeservice.controller;

import com.hyy.eurekaclientarticleeservice.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author admin
 */
@FeignClient(value = "eureka-client-user-service", configuration = FeignConfiguration. class)
public interface UserRemoteClient {
    @GetMapping("/test/hello")
    String hello();
}
