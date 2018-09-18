package com.ryan.citystory.aop.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ryan.citystory.bean.base.ResultBean;
import com.ryan.citystory.custom.constant.ServiceCode;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 日志检测类
 */
@Aspect
@Component
public class ControllerAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("execution(* com.ryan.citystory.controller.*.*(..)))")
    public Object doControllerAround(ProceedingJoinPoint call){
        String methodName = call.getSignature().getName();
        String clazzName = call.getTarget().getClass().getName();
        logger.info("");
        logger.info("");
        logger.info("-----［Ｍｅｔｈｏｄ］："  + methodName + " ---　［Ｓｔａｒｔ］ clazzName：" + clazzName);
        long startTime = System.currentTimeMillis();
        Object result = null;
        try {
            result = call.proceed();
        } catch (Throwable re) {
            re.printStackTrace();
            result = new ResultBean<>(ServiceCode.ERROR,ServiceCode.ERROR_DEFAULT_MSG,null);
        }
        long endTime = System.currentTimeMillis();
        JSONObject jsonObject = null;
        try {
            jsonObject = JSONObject.parseObject(JSON.toJSONString(result));
            if (jsonObject != null && jsonObject.get("data") != null && jsonObject.getString("data").length() > 200){
                jsonObject.put("data",jsonObject.getString("data").substring(0,200) + "...");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ResultBean<String> resultBean = new ResultBean<>(ServiceCode.JSON_FORMART_ERROR, ServiceCode.JSON_ERROR_DEFAULT_MSG, ServiceCode.JSON_ERROR_DEFAULT_MSG);
            jsonObject = JSONObject.parseObject(JSON.toJSONString(resultBean));
        }
        logger.info("");
        logger.info("");
        logger.info("-----［Ｍｅｔｈｏｄ］：" + methodName + " ------　［Ｅｎｄ］　 Result：[" + jsonObject.toJSONString() + "]");
        logger.info("---Runtime：" + (endTime - startTime) + "ms");
        logger.info("");
        logger.info("");

        return result;
    }
}
