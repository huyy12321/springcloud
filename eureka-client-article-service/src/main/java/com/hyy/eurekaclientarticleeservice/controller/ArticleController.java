package com.hyy.eurekaclientarticleeservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author hyy
 */
@RestController
public class ArticleController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserRemoteClient userRemoteClient;

    /**
     * eureka-client-user-service 对应服务提供者配置文件中的名字
     * @return
     */
    @GetMapping("/say")
    public String say(){
        String forObject = restTemplate.getForObject("http://eureka-client-user-service/test/hello", String.class);
        return forObject;
    }

    @GetMapping("/hello")
    public String hello(){
        return userRemoteClient.hello();
    }


    /**
     * Hystrix 容错机制
     * @return
     */
    @GetMapping("/callHello")
    @HystrixCommand(fallbackMethod = "defaultCallHello")
    public String callHello(){
        return restTemplate.getForObject("http://localhost:8088/house/hello", String.class);
    }

    public String defaultCallHello() {
        return "Hystrix 容错机制返回";
    }
}
