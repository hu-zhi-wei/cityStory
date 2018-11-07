package com.ryan.citystory.service.impl;

import com.google.common.base.Converter;
import com.ryan.citystory.bean.Persons;
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
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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

    public static void main(String[] args) throws Exception {

        User user = new User();
        user.setId(1);
        user.setPassword("11");
        user.setUserName("aaa");
        Class<? extends User> aClass = user.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            String f = field.toString().substring(field.toString().lastIndexOf(".")+1);
            String name = field.getName();
            System.out.println(name + "___" + field.get(user));
        }
    }

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final AtomicInteger atomicInteger = new AtomicInteger(1000000);
    /**
     * 创建不连续的订单号
     *
     * @param no
     *            数据中心编号
     * @return 唯一的、不连续订单号
     */
    public static synchronized String getOrderNoByUUID(String no) {
        Integer uuidHashCode = UUID.randomUUID().toString().hashCode();
        if (uuidHashCode < 0) {
            uuidHashCode = uuidHashCode * (-1);
        }
        String date = simpleDateFormat.format(new Date());
        return no + date + uuidHashCode;
    }

    /**
     * 获取同一秒钟 生成的订单号连续
     *
     * @param no
     *            数据中心编号
     * @return 同一秒内订单连续的编号
     */
    public static synchronized String getOrderNoByAtomic(String no) {
        atomicInteger.getAndIncrement();
        int i = atomicInteger.get();
        String date = simpleDateFormat.format(new Date());
        return no + date + i;
    }

}
