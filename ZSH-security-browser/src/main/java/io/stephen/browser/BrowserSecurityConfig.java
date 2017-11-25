package io.stephen.browser;

import io.stephen.browser.authentication.ZSHAuthenticationFailureHandler;
import io.stephen.browser.authentication.ZSHAuthenticationSuccessHandler;
import io.stephen.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @author 10447
 * @since 2017/11/5
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 同一密码每次编码后不同
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 获取配置
     */
    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 登陆失败处理
     */
    @Autowired
    private ZSHAuthenticationFailureHandler zshAuthenticationFailureHandler;

    /**
     * 登陆成功处理
     */
    @Autowired
    private ZSHAuthenticationSuccessHandler zshAuthenticationSuccessHandler;

    @Autowired
    private SpringSocialConfigurer zshSpringSocialConfigurer;


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.apply(zshSpringSocialConfigurer)
                .and().rememberMe()
                .and().formLogin()
                .loginProcessingUrl("/authentication/form")
                .loginPage("/authentication/require")       // 未登陆时重定向到这url
                .successHandler(zshAuthenticationSuccessHandler)
                .failureHandler(zshAuthenticationFailureHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/authentication/require",securityProperties.getBrowser().getSignInPage(),"/login","/authentication/form",
                        "/code/image").permitAll()     // 去掉该url的认证布奏
                .anyRequest()
                .authenticated()
                .and().csrf().disable();

    }
}
