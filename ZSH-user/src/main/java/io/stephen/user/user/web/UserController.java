package io.stephen.user.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> re = restTemplate.getForEntity("http://localhost:8082/user/{1}",String.class,"11");

        String body = re.getBody();

        System.out.println(body);

        System.out.println("discoveryClient Services："+discoveryClient.getServices());


        return discoveryClient.getServices().toString();
    }




}
