package cn.pavi.aaw.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description: 全局接口拦截日志配置类
 * @Author: JreamY
 * @Date: 2021/5/16
 **/
@Aspect
@Component
public class WebLogAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger("interface");

    @Pointcut("execution(public * cn.pavi.aaw.controller..*.*(..))")
    public void webLog() {

    }

    @Before("webLog()")
    public void doBefore(JoinPoint point) {

        LOGGER.info("before start");
    }

    @AfterReturning(returning = "response", pointcut = "webLog()")
    public void doAfterReturning(Object response) {

        LOGGER.info("after return");
    }
}
