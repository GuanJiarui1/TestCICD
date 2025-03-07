package com.guan.service.impl;

import com.guan.dao.UserDao;
import com.guan.entity.User;
import com.guan.entity.dto.LoginRequest;
import com.guan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
//    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // 用户注册
    public User register(User user) {
        return userDao.save(user);
    }

    // 用户登录
    public boolean login(LoginRequest request) {
        userDao.findByUserId(1L);
        return request.getPassword().equals("111111");
    }

    // 获取用户信息
    public User getUser(Long id) {
        return userDao.findByUserId(id);
    }
}
