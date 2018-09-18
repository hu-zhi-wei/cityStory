package com.ryan.citystory;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages= {
        "com.ryan.citystory.controller",
        "com.ryan.citystory.service",
        "com.ryan.citystory.aop",
        "com.ryan.citystory.custom"
})
@MapperScan("com.ryan.citystory.mapper")
@PropertySource(value = "classpath:config.properties")
@ServletComponentScan //filter
public class ServerApi {

    public static void main(String[] args) {
        SpringApplication.run(ServerApi.class, args);
    }
}
