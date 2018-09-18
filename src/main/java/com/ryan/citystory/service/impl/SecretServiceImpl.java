package com.ryan.citystory.service.impl;

import com.ryan.citystory.bean.Secret;
import com.ryan.citystory.config.SecretConstant;
import com.ryan.citystory.custom.config.JmsConfig;
import com.ryan.citystory.custom.constant.ApplicationConfig;
import com.ryan.citystory.mapper.SecretMapper;
import com.ryan.citystory.service.SecretService;
import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.PostConstruct;
import javax.jms.Destination;
import java.util.Date;
import java.util.List;

@Lazy(false)
@Service
@Transactional
public class SecretServiceImpl implements SecretService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SecretMapper secretMapper;
    @Autowired
    private ApplicationConfig config;
    @Autowired
    private JmsConfig jmsConfig;

    @PostConstruct
    @Override
    public void refreshSecret() {
        List<Secret> secrets = secretMapper.findAllByReceiver(config.systemName);
        for (Secret secret : secrets) {
            SecretConstant.secret.put(secret.getSecret(),secret.getTransmi());
        }
        logger.info("秘钥初始化完毕");
    }

    @Override
    public void save(Secret secret) {
        secret.setCreateTime(new Date()).setUpdateTime(secret.getCreateTime());
        secretMapper.save(secret);
    }

    @Override
    public void edit(Secret secret) {
        jmsConfig.sendQueueMessage("修改secret成功");
    }

    public static void main(String[] args) {



    }
}
