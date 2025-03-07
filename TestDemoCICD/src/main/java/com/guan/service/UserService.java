package com.guan.service;

import com.guan.entity.User;
import com.guan.entity.dto.LoginRequest;

public interface UserService {
    public User register(User user);

    public boolean login(LoginRequest request);

    public User getUser(Long id);
}
