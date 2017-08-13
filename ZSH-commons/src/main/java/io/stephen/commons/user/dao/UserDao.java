package io.stephen.commons.user.dao;

import io.stephen.commons.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by zhouShuYi on 2017/7/13.
 *
 * @author zhouShuYi
 */
@Mapper
public interface UserDao {
    List<User> selectUserBean(String id);

    User selectUser(Map<String, Object> param);
}
