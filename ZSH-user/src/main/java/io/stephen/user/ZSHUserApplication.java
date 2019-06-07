package io.stephen.user;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author 10447
 * @since 2017/8/13
 */
@SpringBootApplication
public class ZSHUserApplication {



    public static void main(String[] args) {

        new SpringApplicationBuilder(ZSHUserApplication.class)
                .web(WebApplicationType.REACTIVE)
                .run(args);
    }

}
