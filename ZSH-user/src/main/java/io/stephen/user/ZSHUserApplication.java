package io.stephen.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 10447
 * @since 2017/8/13
 */

@SpringBootApplication
@EnableDiscoveryClient
public class ZSHUserApplication {



    public static void main(String[] args) {
        SpringApplication.run(ZSHUserApplication.class, args);
    }
}
