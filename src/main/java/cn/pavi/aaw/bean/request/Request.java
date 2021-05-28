package cn.pavi.aaw.bean.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 通用请求类
 * @Author: JreamY
 * @Date: 2021/5/17
 **/
@Setter
@Getter
public class Request extends HashMap<String, Object> implements Serializable {

    /**
     * 转发路由标识
     */
    private String serviceId;
    /**
     * 跟踪链
     */
    private String transactionId;
    /**
     * 参数列表
     */
    private Map<String, Object> param;

}
