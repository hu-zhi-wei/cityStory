package com.ryan.citystory.service.impl;

import com.ryan.citystory.bean.Resources;
import com.ryan.citystory.mapper.ResourcesMapper;
import com.ryan.citystory.service.ResourcesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class ResourcesServiceImpl extends BaseServiceImpl<Resources, Integer> implements ResourcesService {

    private ResourcesMapper resourcesMapper;

    @Resource
    public void setResourcesMapper(ResourcesMapper resourcesMapper) {
        this.resourcesMapper = resourcesMapper;
        super.setBaseMapper(resourcesMapper);
    }
}
