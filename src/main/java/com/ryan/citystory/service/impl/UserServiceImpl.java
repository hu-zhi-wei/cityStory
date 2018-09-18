package com.ryan.citystory.service.impl;

import com.ryan.citystory.bean.User;
import com.ryan.citystory.mapper.UserMapper;
import com.ryan.citystory.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void login(User user) {
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("登录失败");
        }
    }

    @Override
    public User findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }
}
