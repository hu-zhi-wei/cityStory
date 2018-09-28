package com.ryan.citystory.controller;

import com.ryan.citystory.bean.Secret;
import com.ryan.citystory.bean.base.ResultBean;
import com.ryan.citystory.custom.constant.ServiceCode;
import com.ryan.citystory.service.SecretService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/secret")
public class SecretController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Configuration configuration;

    @Autowired
    private SecretService secretService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResultBean<?> save(Secret secret) {
        secretService.save(secret);
        return new ResultBean<>(ServiceCode.OK, ServiceCode.OK_DEFAULT_MSG, null);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ResultBean<?> edit(Secret secret) {
        secretService.edit(secret);
        return new ResultBean<>(ServiceCode.OK, ServiceCode.OK_DEFAULT_MSG, null);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResultBean<?> findAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                 @RequestParam(value = "size", defaultValue = "10") Integer size ) {
        secretService.findAll(page, size);
        return new ResultBean<>(ServiceCode.OK, ServiceCode.OK_DEFAULT_MSG, null);
    }

    @RequestMapping(value = "/getFreeMark", method = RequestMethod.GET)
    public void getFreeMark(HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Joe");
        map.put("sex", 1);    //sex:性别，1：男；0：女；

        // 模拟数据
        List<Map<String, Object>> friends = new ArrayList<Map<String, Object>>();
        Map<String, Object> friend = new HashMap<String, Object>();
        friend.put("name", "xbq");
        friend.put("age", 22);
        friends.add(friend);
        friend = new HashMap<String, Object>();
        friend.put("name", "July");
        friend.put("age", 18);
        friends.add(friend);
        map.put("friends", friends);
        Template template = null;
        try {
            configuration.setDefaultEncoding("UTF-8");
            template = configuration.getTemplate("aaa.ftl");
            //解决freeMark中文乱码
            response.setContentType("text/html; charset=" + template.getEncoding());
            template.process(map, response.getWriter());
            response.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
