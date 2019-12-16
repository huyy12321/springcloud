package com.hyy.apollo.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hyy
 */
@RestController
public class TestController {
    @ApolloConfig
   private Config config;

    @GetMapping("/hello")
    public String hello() {
        return config.getProperty("hyy", "zhangsan");
    }

    @ApolloConfigChangeListener
    private void someOnChange(ConfigChangeEvent changeEvent) {
        if(changeEvent.isChanged("hyy")) {
            System.out.println("username发生修改了");
        }
    }
}
