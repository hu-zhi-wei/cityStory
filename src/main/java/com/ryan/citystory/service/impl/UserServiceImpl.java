package com.ryan.citystory.service.impl;

import com.ryan.citystory.bean.User;
import com.ryan.citystory.mapper.UserMapper;
import com.ryan.citystory.service.UserService;
import com.ryan.citystory.utils.RandomUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user, HttpServletRequest request) {
        //添加用户认证信息
        user.setPassword(RandomUtil.getMd5(user.getUserName(), user.getPassword()));
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
//        try {
            subject.login(token);
            User loginUser = (User)subject.getPrincipal();
            return loginUser;
//        } catch (AuthenticationException e) {
//            e.printStackTrace();
//            System.out.println("登录失败");
//        }
    }

    @Override
    public User findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }
}
