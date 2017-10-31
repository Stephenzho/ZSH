package io.stephen.commons.user.web;

import io.stephen.commons.domain.entity.User;
import io.stephen.commons.security.util.JwtTokenUtil;
import io.stephen.commons.user.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 10447
 * @since 2017/8/2
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService ;


    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    /**
     * 该链接获取token
     */
    @GetMapping("/auth")
    public Map auth(String userName, String password) {
        Map<String, Object> map = new HashMap<>();

        User user = null;
        if (StringUtils.isNotBlank(userName)){
            map.put("userName", userName);

        //    user = userService.selectUserByUserName(map);
            user = new User();
            user.setUserID("111");
            user.setUserName("stephen");
            user.setPassword("zhou104477");
            user.setSex("W");
            user.setEnabled("1");
            user.setEmail("123@qq.com");
            user.setAvatar("1");


            map.clear();
        }

        if (null != user && StringUtils.isNotBlank(password) && user.getPassword().equals(password)) {
            map.put("status", 1);
            map.put("msg", "Success");
            List<String> roleList = new ArrayList();
            roleList.add("ADMIN");

            map.put("token", jwtTokenUtil.create(user));
        } else {
            map.put("status", 0);
            map.put("msg", "err");
            map.put("token", null);
        }

        return map;
    }


    @GetMapping()
    public void ex() throws Exception {
        throw new Exception("┏┛墓┗┓...(((m -__-)m");
    }

}
