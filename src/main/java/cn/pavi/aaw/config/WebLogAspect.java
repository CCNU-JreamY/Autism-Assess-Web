package cn.pavi.aaw.config;

import cn.pavi.aaw.bean.request.Request;
import cn.pavi.aaw.constant.Constant;
import cn.pavi.aaw.util.FlakeUtils;
import cn.pavi.aaw.util.JSONUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @Description: 全局接口拦截日志配置类
 * @Author: JreamY
 * @Date: 2021/5/16
 **/
@Aspect
@Component
public class WebLogAspect implements Ordered {

    private final static Logger LOGGER = LoggerFactory.getLogger("interface");

    @Pointcut("execution(public * cn.pavi.aaw.controller..*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void webLogDoBefore(JoinPoint point) {

        Object[] arguments = point.getArgs();
        if (!Request.class.isInstance(arguments[0])) {
            LOGGER.info("request: {}");
            return;
        }
        Request request = (Request) arguments[0];
        if (StringUtils.isEmpty(request.getTransactionId())) {
            request.setTransactionId(FlakeUtils.nextWorkerId());
        }
        MDC.put(Constant.MDC.TRANSACTION_ID, request.getTransactionId());
        request.setServiceId((String) request.get(Constant.Request.SERVICE_ID));
        request.setParam((Map) request.get(Constant.Request.PARAM));
        LOGGER.info("request: {}", JSONUtils.toJSON(request));
        request.put(Constant.Request.SERVICE_ID, null);
        request.put(Constant.Request.PARAM, null);
    }

    @AfterReturning(returning = "response", pointcut = "webLog()")
    public void webLogDoAfterReturning(Object response) {
        LOGGER.info("response: {}", JSONUtils.toJSON(response));
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
