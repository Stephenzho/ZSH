package io.stephen.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author 10447
 * @since 2017/8/13
 */
//@EnableFeignClients
@SpringBootApplication
//@EnableDiscoveryClient      // 开启服务发现
public class ZSHUserApplication {



    public static void main(String[] args) {
        SpringApplication.run(ZSHUserApplication.class, args);
    }


    @Bean
    //@LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
