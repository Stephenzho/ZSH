package io.stephen.commons.user.service;

import io.stephen.commons.domain.entity.User;
import io.stephen.commons.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * spring security 提供的一个service接口
 *
 *
 * @author zhouShuYi
 * @since  2017/8/1
 */
@Service
public class userServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 根据用户名查找用户
     * @param param
     * @return
     * @throws UsernameNotFoundException
     */
    public User selectUserByUserName(Map<String, Object> param){
        return userDao.selectUser(param);
    }
}
