package com.ryan.citystory.controller;


import com.ryan.citystory.bean.User;
import com.ryan.citystory.bean.base.ResultBean;
import com.ryan.citystory.custom.constant.ServiceCode;
import com.ryan.citystory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(User user, HttpServletRequest request){
        ModelAndView modelAndView = null;
        try {
            User login = userService.login(user, request);
            modelAndView = new ModelAndView("redirect:/index.jsp");//重定向
            modelAndView.addObject("user",login);
            return modelAndView;
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView = new ModelAndView("redirect:/login.jsp");//重定向
            return modelAndView;
        }

    }
}
