package com.hyy.eurekaclientarticleeservice.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * @author hyy
 */
public class FeignBasicAuthRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        System.out.println("业务逻辑");
    }
}
