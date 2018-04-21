package io.stephen.test;

import io.stephen.test.filter.EncryptionFilter;
import io.stephen.test.web.SecurityParameter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;


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
