package com.ryan.citystory.custom.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class UserJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("userJob执行了 : " + new SimpleDateFormat("yyyy=MM-dd HH:mm:ss").format(new Date()));
    }
}
