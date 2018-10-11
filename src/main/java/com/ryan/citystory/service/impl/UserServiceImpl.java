package com.ryan.citystory.service.impl;

import com.ryan.citystory.bean.Resources;
import com.ryan.citystory.bean.User;
import com.ryan.citystory.mapper.UsersMapper;
import com.ryan.citystory.service.UserService;
import com.ryan.citystory.utils.RandomUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements UserService {

    private UsersMapper usersMapper;

    @Resource
    public void setUsersMapper(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
        super.setBaseMapper(usersMapper);
    }

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
        return usersMapper.findByUserName(userName);
    }

    @Override
    public Set<Resources> getResourcesByUserId(Integer id) {
        return usersMapper.getResourcesByUserId(id);
    }

    public static void main(String[] args) throws IOException {
        InputStream in = UserServiceImpl.class.getResourceAsStream("/sign/privateKey.keystore");
        System.out.println(in);
        InputStreamReader isr=new InputStreamReader (in);
        BufferedReader br = new BufferedReader(isr);
        String line2="";
        while ((line2=br.readLine())!=null) {
            System.out.println("------------------------");
            System.out.println(line2);
        }
    }
}
