package com.ryan.citystory.service.impl;

import com.ryan.citystory.bean.RoleResource;
import com.ryan.citystory.mapper.RoleResourceMapper;
import com.ryan.citystory.service.RoleResourceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class RoleResourceServiceImpl extends BaseServiceImpl<RoleResource, Integer> implements RoleResourceService {

    private RoleResourceMapper roleResourceMapper;

    @Resource
    public void setRoleResourceMapper(RoleResourceMapper roleResourceMapper) {
        this.roleResourceMapper = roleResourceMapper;
        super.setBaseMapper(roleResourceMapper);
    }
}
