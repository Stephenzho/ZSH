package io.stephen.browser.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.authentication.PasswordEncoderParser;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.PasswordAuthentication;

/**
 * @author 10447
 * @since 2017/11/6
 */
@Service
public class UserService implements UserDetailsService {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    public PasswordEncoder passwordEncoder;

    /**
     * 根据username查询user
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("username ："+username);
        log.info("password编码后："+passwordEncoder.encode("111111"));

        // UserDetails 四种状态其一为false则无法登陆
        return new User(username, passwordEncoder.encode("111111"),
                true,true,true,true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }

}
