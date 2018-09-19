package com.ryan.citystory.custom.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


@Configuration
@Component // 此注解必加
@EnableScheduling // 此注解必加
public class ScheduleTask {

        /**
         * 发送告警通知
         */
        public void scheduleTest() {
            System.out.println("当前时间为: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            System.err.println("scheduleTest开始定时执行");
        }

        public void scheduleTest2() {
            System.out.println("当前时间为: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            System.err.println("scheduleTest开始定时执行");
        }

}
