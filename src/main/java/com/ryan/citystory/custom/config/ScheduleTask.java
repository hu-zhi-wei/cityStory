package com.ryan.citystory.custom.config;

import com.alibaba.fastjson.JSON;
import com.ryan.citystory.bean.Secret;
import com.ryan.citystory.service.SecretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Configuration
@Component // 此注解必加
@EnableScheduling // 此注解必加
public class ScheduleTask {

    @Autowired
    private SecretService secretService;
        /**
         * 发送告警通知
         */
        public void scheduleTest() {
            System.out.println("当前时间为: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            List<Secret> all = secretService.findAll(1, 10);
            System.err.println("scheduleTest开始定时执行结果: " + JSON.toJSONString(all));
        }

        public void scheduleTest2() {
            System.out.println("当前时间为: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            System.err.println("scheduleTest开始定时执行");
        }

}
