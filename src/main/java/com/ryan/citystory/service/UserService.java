package com.ryan.citystory.service;

import com.ryan.citystory.bean.Resources;
import com.ryan.citystory.bean.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

public interface UserService extends BaseService<User, Integer> {

    User login(User user, HttpServletRequest request);

    User findByUserName(String userName);

    Set<Resources> getResourcesByUserId(Integer id);

    default String defaultFunction() {
        System.out.println("wo shi default function!!!");
               return "default function";
            }
    static String get(){
        return "hello word";
    }
}
