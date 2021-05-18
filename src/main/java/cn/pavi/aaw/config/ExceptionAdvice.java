package cn.pavi.aaw.config;

import cn.pavi.aaw.bean.exception.SystemException;
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

    @ExceptionHandler(SystemException.class)
    public Object systemExceptionHandler(HttpServletRequest request, HttpServletResponse response, SystemException exception) {

        LOGGER.error("全局自定义异常拦截成功");
        return null;
    }

    @ExceptionHandler(Exception.class)
    public Object exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception exception) {

        LOGGER.error("全局异常拦截成功");
        return null;
    }
}
