package io.stephen.user.user.web;

import io.stephen.user.Commons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 10447
 * @since 2018/1/17
 */

@RestController
public class FeignController {

    @Autowired
    private Commons commons;


    @GetMapping("/fei")
    public String fei() {
        return commons.dc();
    }


}
