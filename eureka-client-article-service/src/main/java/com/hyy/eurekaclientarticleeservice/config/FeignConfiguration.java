package com.hyy.eurekaclientarticleeservice.config;

import feign.Logger;
import feign.Request;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hyy
 *
 */
@Configuration
public class FeignConfiguration {

    /**
     * 开启Feign日志
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    /**
     * 超时设置
     * @return
     */
    @Bean
    public Request.Options options() {
        return new Request.Options(5000, 10000);
    }

    /**
     * 请求拦截器，在Feign发出请求前调用apply方法，进行权限检验，在请求头设置token之类的
     * @return
     */
    @Bean
    public FeignBasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new FeignBasicAuthRequestInterceptor();
    }

//    @Bean
//    public Decoder decoder() {
//        return new MyDecoder();
//    }
//    @Bean
//    public Encoder encoder() {
//        return new MyEncoder();
//    }
}
