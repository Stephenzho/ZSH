package io.stephen.user.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * Created by 10447 on 2017/7/9.
 */
@RestController
public class UserController {

    private final Logger logger = Logger.getLogger(String.valueOf(getClass()));

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String  userDetail() {





        System.out.println(discoveryClient.getServices());


        return discoveryClient.getServices().toString();
    }




}
