package io.stephen.security.demo;

import com.fasterxml.jackson.annotation.JsonView;
import io.stephen.security.dto.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author 10447
 * @since 2017/10/29
 */
@SpringBootApplication
@RestController
@RequestMapping("/user")
public class DemoApplication {


    @GetMapping("/{id:\\d+}")
    @JsonView(User.userDetailView.class)
    public User getInfo(@PathVariable String id) {

        User user = new User();
        user.setId(id);
        user.setPassword("12312");
        user.setUsername("stephen");
        return user;
    }


    @GetMapping
    @JsonView(User.userSimpleView.class)
    public User hello(@RequestParam() Map<String,Object> param){
        System.out.println("得到的："+param);

        User user = new User();
        user.setId((String) param.get("id"));
        user.setPassword("12312");
        user.setUsername("stephen");
        return user;
    }


    public static void main(String[] arg) {
        SpringApplication.run(DemoApplication.class, arg);
    }

}
