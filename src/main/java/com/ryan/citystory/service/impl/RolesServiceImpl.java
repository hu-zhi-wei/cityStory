package com.ryan.citystory.service.impl;

import com.ryan.citystory.bean.Roles;
import com.ryan.citystory.mapper.RolesMapper;
import com.ryan.citystory.service.RolesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service
@Transactional
public class RolesServiceImpl extends BaseServiceImpl<Roles, Integer> implements RolesService {

    private RolesMapper rolesMapper;

    @Resource
    public void setRolesMapper(RolesMapper rolesMapper) {
        this.rolesMapper = rolesMapper;
        super.setBaseMapper(rolesMapper);
    }
}
