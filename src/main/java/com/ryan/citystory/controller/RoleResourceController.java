package com.ryan.citystory.controller;

import com.ryan.citystory.bean.RoleResource;
import com.ryan.citystory.service.RoleResourceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/roleResource")
public class RoleResourceController extends BaseController<RoleResource, Integer> {

    private RoleResourceService roleResourceService;

    @Resource
    public void setRoleResourceService(RoleResourceService roleResourceService) {
        this.roleResourceService = roleResourceService;
        super.setBaseService(roleResourceService);
    }
}
