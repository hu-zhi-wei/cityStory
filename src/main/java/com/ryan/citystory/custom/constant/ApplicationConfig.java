package com.ryan.citystory.custom.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConfig {

    @Value("${system.name}")
    public String systemName;

    @Value("${jms.mq.queue}")
    public String queueName;

    @Value("${jms.mq.topic}")
    public String topicName;

    @Value("${jms.mq.username}")
    public String mqUserName;

    @Value("${jms.mq.password}")
    public String mqPassword;

    @Value("${jms.mq.connect}")
    public String mqConnect;


}
