package com.hyy.eurekaclientarticleeservice.controller;

import org.springframework.stereotype.Component;

/**
 * @author hyy
 */
@Component
public class UserRemoteClientFallback implements UserRemoteClient{
    @Override
    public String hello() {
        return "触发Hystrix回退";
    }
}
