package com.hyy.eurekaclientarticleeservice.controller;

import com.hyy.eurekaclientarticleeservice.config.FeignConfiguration;
import com.hyy.eurekaclientarticleeservice.config.UserRemoteClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author admin
 * fallback   增加Hystrix的回退
 */
//@FeignClient(value = "eureka-client-user-service", configuration = FeignConfiguration. class, fallback = UserRemoteClientFallback.class)
@FeignClient(value = "eureka-client-user-service", configuration = FeignConfiguration. class, fallbackFactory = UserRemoteClientFallbackFactory.class)
public interface UserRemoteClient {
    @GetMapping("/test/hello")
    String hello();
}
