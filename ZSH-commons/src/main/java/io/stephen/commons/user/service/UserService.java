package io.stephen.commons.user.service;

import io.stephen.commons.domain.entity.User;

import java.util.Map;

/**
 * @author 10447
 * @since 2017/8/1
 */
public interface UserService {

    User selectUserByUserName(Map<String, Object> param);
}
