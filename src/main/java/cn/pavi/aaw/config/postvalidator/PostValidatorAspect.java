package cn.pavi.aaw.config.postvalidator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @Description: post请求参数校验注解解析类
 * @Author: JreamY
 * @Date: 2021/5/19
 **/
@Aspect
@Component
public class PostValidatorAspect implements Ordered {

    private final static Logger LOGGER = LoggerFactory.getLogger(PostValidatorAspect.class);

    @Before("@annotation(cn.pavi.aaw.annotation.PostValidator)")
    public void postValidateDoBefore(JoinPoint point) {

        LOGGER.info("post validate do before");
    }

    @Override
    public int getOrder() {
        return 10;
    }
}
