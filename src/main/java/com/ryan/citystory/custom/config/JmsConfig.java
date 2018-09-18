package com.ryan.citystory.custom.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

@Component
public class JmsConfig {

    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    // 发送消息，destination是发送到的队列，message是待发送的消息
    public void sendMessage(Destination destination, final String message) {
        jmsTemplate.convertAndSend(destination, message);
    }

    /**
     * 使用默认的消息队列
     * @param message
     */
    public void sendQueueMessage( final String message) {
        jmsTemplate.convertAndSend(queue, message);
    }
    /**
     * 使用默认的消息队列
     * @param message
     */
    public void sendTopicMessage( final String message) {
        jmsTemplate.convertAndSend(topic, message);
    }
}
