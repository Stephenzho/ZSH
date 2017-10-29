package io.stephen.security.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 10447
 * @since 2017/10/29
 */
@SpringBootApplication
@RestController
public class DemoApplication {



    @GetMapping("hello")
    public String hello(){
        return "hello Spring Security";
    }


    public static void main(String[] arg) {
        SpringApplication.run(DemoApplication.class, arg);
    }

}
