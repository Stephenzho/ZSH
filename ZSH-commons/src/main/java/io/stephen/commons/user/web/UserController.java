package io.stephen.commons.user.web;

import io.stephen.commons.domain.entity.User;
import io.stephen.commons.security.dto.TokenUserDTO;
import io.stephen.commons.security.util.JwtTokenUtil;
import io.stephen.commons.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by 10447 on 2017/7/9.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService ;


    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    /**
     * 该链接尝试获取登录用户,返回该认证用户的信息,请求该链接需要在header中放入x-authorization: token
     */
    @GetMapping("/detail")
    public TokenUserDTO userDetail() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (Objects.isNull(authentication)) {
            return null;
        }
        return (TokenUserDTO) authentication.getDetails();
    }

    @PostMapping("add")
    public String addUser(){

        System.out.println("添加用户");
        return "牛逼";
    }

    @PutMapping()
    public void updateUser(@PathVariable User user) {
        System.out.println("更新用户"+user.toString());

    }


    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) throws Exception {
        System.out.println("获取用户ID为"+id+"的用户。");
        throw new Exception("我日");
    }



}
