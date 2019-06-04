package io.stephen.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 10447
 * @since 2018/1/17
 */

@RestController
public class FeignController {




    @GetMapping("/fei")
    public String fei() {
        return "Feign";
    }


}
