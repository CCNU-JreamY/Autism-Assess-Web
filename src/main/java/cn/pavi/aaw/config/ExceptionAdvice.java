package cn.pavi.aaw.config;

import cn.pavi.aaw.bean.exception.SystemException;
import cn.pavi.aaw.bean.response.Response;
import cn.pavi.aaw.enums.Error;
import cn.pavi.aaw.util.JSONUtils;
import cn.pavi.aaw.util.LogUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 全局异常拦截配置类
 * @Author: JreamY
 * @Date: 2021/5/16
 **/
@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(SystemException.class)
    @ResponseBody
    public Response systemExceptionHandler(SystemException exception) {

        LogUtils.error("系统自定义异常拦截：{}", exception.toString());
        Response response = Response.newFailure(Error.CUSTOM_SYSTEM_ERROR, exception.getPrivDesc());
        response.setErrorDesc(exception.getPubDesc());
        LogUtils.inter("response: {}", JSONUtils.toJSON(response));
        return response;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object exceptionHandler(Exception exception) {

        LogUtils.error("系统异常拦截: 异常描述 -> {}, 异常位置 -> {}", exception.getMessage(), exception.getStackTrace()[0]);
        Response response = Response.newFailure(Error.SYSTEM_ERROR);
        LogUtils.inter("response: {}", JSONUtils.toJSON(response));
        return response;
    }
}
