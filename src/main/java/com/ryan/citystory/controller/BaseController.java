package com.ryan.citystory.controller;


import com.ryan.citystory.bean.base.ResultBean;
import com.ryan.citystory.custom.constant.ServiceCode;
import com.ryan.citystory.service.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public class BaseController<T, E> {

    private BaseService baseService;

    public void setBaseService(BaseService baseService) {
        this.baseService = baseService;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResultBean<?> save(T t){
        baseService.save(t);
        return new ResultBean<>(ServiceCode.OK, ServiceCode.OK_DEFAULT_MSG, null);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ResultBean<?> edit(T t){
        baseService.edit(t);
        return new ResultBean<>(ServiceCode.OK, ServiceCode.OK_DEFAULT_MSG, null);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ResultBean<?> delete(@RequestParam("id") E e){
        baseService.delete(e);
        return new ResultBean<>(ServiceCode.OK, ServiceCode.OK_DEFAULT_MSG, null);
    }

    @RequestMapping(value = "/findByObject", method = RequestMethod.POST)
    public ResultBean<?> findByObject(T t){
        return new ResultBean<>(ServiceCode.OK, ServiceCode.OK_DEFAULT_MSG, baseService.findByObject(t));
    }
}
