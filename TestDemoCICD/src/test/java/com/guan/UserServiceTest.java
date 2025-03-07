package com.guan;

import com.guan.dao.impl.UserDaoImpl;
import com.guan.entity.User;
import com.guan.entity.dto.LoginRequest;
import com.guan.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * 单元测试
 */
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock//代理该方法 模拟该方法的输入与返回 保证在测试时不访问外部真实值或真实组件
    private UserDaoImpl userDao;

    @InjectMocks//将Mock字段代理的属性注入到该方法中
    private UserServiceImpl userService;

    @Test
    public void testRegisterUser() {
        User user = new User(1L, "testUser", "password");
        when(userDao.save(any())).thenReturn(user);

        User result = userService.register(user);
        assertNotNull(result);
        assertEquals("testUser", result.getUsername());
    }

    @Test
    public void testLoginSuccess() {
        User user = new User(1L, "testUser", "password");
        when(userDao.findByUserId(1L)).thenReturn(user);

        boolean result = userService.login(new LoginRequest("testUser", "password"));
        System.out.println(result);
    }

    @Test
    public void testLoginFail() {
        User user = new User(1L, "testUser", "password");
        when(userDao.findByUserId(1L)).thenReturn(user);

        boolean result = userService.login(new LoginRequest("testUser", "wrongPass"));
        System.out.println(result);
    }
}
