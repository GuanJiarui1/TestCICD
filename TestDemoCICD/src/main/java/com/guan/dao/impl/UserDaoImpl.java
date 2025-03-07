package com.guan.dao.impl;

import com.guan.dao.UserDao;
import com.guan.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {
    @Override
    public User save(User user) {
        return user;
    }

    @Override
    public User findByUserId(long id) {
        User user = new User();
        user.setId(id);
        return user;
    }
}
