package cn.pavi.aaw.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 全局异常拦截配置类
 * @Author: JreamY
 * @Date: 2021/5/16
 **/
@ControllerAdvice
public class ExceptionAdvice {

    private final static Logger LOGGER = LoggerFactory.getLogger("error");

    @ExceptionHandler(Exception.class)
    public Object exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {

        LOGGER.error("全局异常拦截成功");
        return null;
    }
}
