package com.hyy.eurekaclientarticleeservice.config;

import com.hyy.eurekaclientarticleeservice.controller.UserRemoteClient;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author hyy
 */
@Component
@Slf4j
public class UserRemoteClientFallbackFactory implements FallbackFactory<UserRemoteClient> {
    @Override
    public UserRemoteClient create(Throwable throwable) {
        log.error("UserRemoteClient回退：", throwable);
        return new UserRemoteClient() {
            @Override
            public String hello() {
                return "UserRemoteClient回退：";
            }
        };
    }
}
