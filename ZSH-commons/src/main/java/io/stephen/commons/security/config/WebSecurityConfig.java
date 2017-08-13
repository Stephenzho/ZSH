package io.stephen.commons.security.config;

import io.stephen.commons.security.filter.ValidateTokenFilter;
import io.stephen.commons.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by zhouShuYi on 2017/7/13.
 *
 * @author zhouShuYi
 */
@Configurable
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    /**
     * 配置Filter链
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        // 每一个请求对应一个空的filter链,这里一般不要配置过多,
        // 因为查找处是一个for循环,过多就导致每个请求都需要循环一遍直到找到
        web.ignoring().antMatchers("/login");
    }

    /**
     * 通过拦截器保护请求
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            // 对于获取token的rest api要允许匿名访问
            .antMatchers("/auth/**","/**/*.js","/**/*.css","/**/*.html").permitAll()
            .anyRequest().permitAll().and()
            .rememberMe().and()
            //异常处理,可以再此使用entrypoint来定义错误输出
            .exceptionHandling().and()
            //不需要session来控制,所以这里可以去掉
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            //因为没用到cookies,所以关闭cookies
            .csrf().disable()
            //开启匿名访问
            .anonymous().and()
            //退出登录自己来控制
            .logout().disable()
            //验证token
            .addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
    }


    @Bean
    public ValidateTokenFilter authenticationTokenFilterBean() {
        return new ValidateTokenFilter();
    }


}
