package com.guan.dao;

import com.guan.entity.User;
import org.springframework.stereotype.Component;

public interface UserDao {

    User save(User user);

    User findByUserId(long id);
}
