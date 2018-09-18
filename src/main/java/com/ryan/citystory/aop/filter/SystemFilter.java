package com.ryan.citystory.aop.filter;

import com.alibaba.fastjson.JSONObject;
import com.ryan.citystory.bean.base.ResultBean;
import com.ryan.citystory.config.SecretConstant;
import com.ryan.citystory.custom.constant.ServiceCode;
import com.ryan.citystory.utils.SystemUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Order(1)
//重点
@WebFilter(filterName = "systemFilter", urlPatterns = "/*")
public class SystemFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(SystemFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        res.setHeader("Access-Control-Max-Age", "3600");
        res.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
        res.setHeader("Access-Control-Allow-Credentials", "true");
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        logger.info("");
        logger.info("************    REQUEST BEGIN    ************");
        logger.info(String.format("请求方式：%s --- 请求路径：%s",req.getMethod(),req.getServletPath()));
        /* 判断是否授权 */
//        if (req.getServletPath().contains(".jsp") || req.getServletPath().contains(".css") || req.getServletPath().contains(".ico")){
//
//        }else {
//            String secret = StringUtils.isNotBlank(req.getHeader("secret")) ? SecretConstant.secret.get(req.getHeader("secret")) : null;
//            if ( StringUtils.isBlank(secret)){
//                logger.info("请求未授权 ****** IP：{}，Method：{}，Url：{}，Secret：{}",SystemUtil.getClientIP(req),req.getMethod(),req.getServletPath(),secret);
//                printSecretError(res);
//                return;
//            }
//        }

        Date beginDate = new Date();
        /*  打印参数 */
        StringBuffer sb = printParams(new StringBuffer(), new HashMap<>(), req);
        /* 放行请求 */
        filterChain.doFilter(servletRequest, servletResponse);
        long time = new Date().getTime() - beginDate.getTime();
        logger.info("请求IP：{} --- 请求方式：{} --- 请求路径：{} --- 请求耗时：{}",SystemUtil.getClientIP(req),req.getMethod(),req.getServletPath(),time);
        logger.info(sb.toString());
        logger.info("************    REQUEST END    ************");
        logger.info("");
    }

    @Override
    public void destroy() {
        logger.info("");
        logger.info("************     程序正在退出     ************");
        logger.info("");
    }

    /**
     * 返回未授权错误信息
     */
    private void printSecretError(ServletResponse response){
        try {
            response.setContentType("application/json; charset=utf-8");
            PrintWriter out = response.getWriter();
            ResultBean<String> result = new ResultBean<String>();
            result.setRetCode(ServiceCode.UNAUTHORIZED);
            result.setRetMsg(ServiceCode.UNAUTHORIZED_DEFAULT_MSG);
            result.setData("未授权,请传递secret");
            out.print(JSONObject.toJSONString(result));
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 打印参数
     * @param stb
     * @param params
     * @param request
     */
    private StringBuffer printParams(StringBuffer stb, Map<String, String> params, ServletRequest request) {
        Enumeration enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String key = (String) enu.nextElement();
            String value = request.getParameter(key);
            params.put(key, value);
            if (!key.contains("password")) {
                stb.append(key + "=" + value + "&");
                //参数打印
                if (StringUtils.isBlank(value)) {
                    //logger.info("param_data " + key + "=");
                } else {
                    logger.info("param_data " + key + "=" + value);
                }
            } else {
                stb.append(key + "=******&");
            }
        }
        return stb;
    }
}
