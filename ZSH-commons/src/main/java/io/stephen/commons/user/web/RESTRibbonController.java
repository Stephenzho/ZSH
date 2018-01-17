package io.stephen.commons.user.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 10447
 * @since 2018/1/17
 */
@RestController
public class RESTRibbonController {


    @RequestMapping("/dcc")
    public Map<String, String> dc() {

        System.out.println("来请求");
        Map<String, String> map = new HashMap<>();
        map.put("msg","成功");

        return map;
    }

}
