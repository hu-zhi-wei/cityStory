package com.ryan.citystory.service.impl;

import com.ryan.citystory.bean.UserRoles;
import com.ryan.citystory.mapper.UserRolesMapper;
import com.ryan.citystory.service.UserRolesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class UserRolesServiceImpl extends BaseServiceImpl<UserRoles, Integer> implements UserRolesService {

    private UserRolesMapper userRolesMapper;

    @Resource
    public void setUserRolesMapper(UserRolesMapper userRolesMapper) {
        this.userRolesMapper = userRolesMapper;
        super.setBaseMapper(userRolesMapper);
    }
}
