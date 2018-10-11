package com.ryan.citystory.service.impl;

import com.ryan.citystory.mapper.BaseMapper;
import com.ryan.citystory.service.BaseService;

import java.util.List;

public class BaseServiceImpl<T, E> implements BaseService<T, E> {


    private BaseMapper<T, E> baseMapper;

    public void setBaseMapper(BaseMapper<T, E> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    public void save(T t) {
        baseMapper.insert(t);
    }

    @Override
    public void edit(T t) {
        baseMapper.updateByPrimaryKey(t);
    }

    @Override
    public void delete(E e) {
        baseMapper.deleteByPrimaryKey(e);
    }

    @Override
    public List<T> findByObject(T t) {
        return baseMapper.findByObject(t);
    }
}
