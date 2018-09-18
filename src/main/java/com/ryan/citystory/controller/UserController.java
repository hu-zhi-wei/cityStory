package com.ryan.citystory.controller;


import com.ryan.citystory.bean.User;
import com.ryan.citystory.bean.base.ResultBean;
import com.ryan.citystory.custom.constant.ServiceCode;
import com.ryan.citystory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultBean<?> login(User user){
        userService.login(user);
        return new ResultBean<>(ServiceCode.OK, ServiceCode.OK_DEFAULT_MSG, null);
    }
}
