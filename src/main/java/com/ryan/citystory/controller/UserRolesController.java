package com.ryan.citystory.controller;

import com.ryan.citystory.bean.UserRoles;
import com.ryan.citystory.service.UserRolesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/userRoles")
public class UserRolesController extends BaseController<UserRoles, Integer> {

    private UserRolesService userRolesService;

    @Resource
    public void setUserRolesService(UserRolesService userRolesService) {
        this.userRolesService = userRolesService;
        super.setBaseService(userRolesService);
    }
}
