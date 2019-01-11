package io.stephen.security.demo.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import io.stephen.core.exceptionHandle.CommonException;
import io.stephen.security.demo.dto.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author 10447
 * @since 2017/10/29
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private Logger logger =  LoggerFactory.getLogger(getClass());


    /**
     * 返回认证信息,@AuthenticationPrincipal 简化认证信息
     * @param user
     * @return
     */
    @GetMapping("/me")
    public Object getAuthenrication(@AuthenticationPrincipal UserDetails user) {
        return user;
    }


    /**
     * 注册用户
     * @param user
     */
    @PostMapping("/regist")
    public void regist(User user) {

        logger.info("注册用户：{}", user);
    }


    @GetMapping("/ex")
    public void testException() throws Exception {

        throw new CommonException("1212", "内部错误");
    }

    /**
     * @param user
     * @param errors
     * @return
     * @Valid 开启 notBlock注解验证，BindingResult为验证错误信息结果
     */
    @PostMapping
    public User validData(@Valid @RequestBody User user, BindingResult errors) {

        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> {

                FieldError fieldError = (FieldError) error;

                System.out.println(fieldError.getDefaultMessage());

            });
        }
        user.setId("1");
        return user;
    }


    /**
     * 注解@PathVariable 获取RESUful请求参数到方法参数上
     *
     * @param id
     * @return
     */
    @GetMapping("/{id:\\d+}")
    @JsonView(User.userDetailView.class)
    @ApiOperation("获取用户信息")
    public User getInfo(@ApiParam("用户ID") @PathVariable String id) {

        User user = new User();
        user.setId(id);
        user.setPassword("12312");
        user.setUsername("stephen");
        return user;
    }


    /**
     * 注解@RequestParam 简单的请求参数获取
     *
     * @param user
     * @return
     */
    @GetMapping
    @JsonView(User.userSimpleView.class)
    public User hello(@RequestParam() User user) {
        System.out.println("得到的：" + user);

        user.setId( user.getId());
        user.setPassword("12312");
        user.setUsername("stephen");
        return user;
    }


}
