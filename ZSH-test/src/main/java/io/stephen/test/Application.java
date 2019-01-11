package io.stephen.test;

import io.stephen.test.annotation.Ot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author 10447
 * @since 2018/4/16
 */
@SpringBootApplication
public class Application {



    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }



/*
    *//**
     * 配置过滤器
     * @return
     *//*
    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(sessionFilter());
        registration.addUrlPatterns("*//*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("sessionFilter");
        return registration;
    }

    *//**
     * 创建一个bean
     * @return
     *//*
    @Bean(name = "sessionFilter")
    public Filter sessionFilter() {
        return new EncryptionFilter();
    }*/
}
