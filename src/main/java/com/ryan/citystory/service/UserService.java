package com.ryan.citystory.service;

import com.ryan.citystory.bean.User;

public interface UserService {
    void login(User user);

    User findByUserName(String userName);
}
