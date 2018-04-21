package io.stephen.test.web;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 10447
 * @since 2018/4/16
 */
@RestController()
public class cosdf {

    @RequestMapping("/test")
    public Object res(@RequestBody String  param){

        System.out.println(param);

        Map<String, String> par = new HashMap<>();
        par.put("name","123");
        return par;
    }

}
