package com.ryan.citystory.service;

import com.ryan.citystory.bean.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    User login(User user, HttpServletRequest request);

    User findByUserName(String userName);
}
