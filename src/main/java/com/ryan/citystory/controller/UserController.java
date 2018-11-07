package com.ryan.citystory.controller;


import com.ryan.citystory.bean.User;
import com.ryan.citystory.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController<User, Integer> {

    private UserService userService;

    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
        super.setBaseService(userService);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, HttpServletRequest request, Model model){
        try {
            userService.defaultFunction();
            User login = userService.login(user, request);
            model.addAttribute("user", login);
            return "index";
        } catch (Exception e) {
            e.printStackTrace();
            return "login";
        }
    }

}
