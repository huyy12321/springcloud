package com.hyy.eurekaclientarticleeservice.controller;

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
        return restTemplate.getForObject("http://eureka-client-user-service/test/hello",String.class);
    }

    @GetMapping("/hello")
    public String hello(){
        return userRemoteClient.hello();
    }
}
