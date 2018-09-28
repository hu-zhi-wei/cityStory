package com.ryan.citystory.aop.listener;

import com.ryan.citystory.service.SecretService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitListener implements ServletContextListener {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("");
        logger.info("");
        logger.info("******************* SYSTEM INIT START ***************** ");
        //spring容器中获取service对象
        SecretService service = WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext()).getBean(SecretService.class);
        service.refreshSecret();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("******************* SYSTEM EXIT *****************");
        logger.info("");
        logger.info("");
    }

    public static void main(String[] args) {


    }
}
