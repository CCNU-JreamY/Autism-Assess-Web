package cn.pavi.aaw.bean.request;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @Description: 通用请求类
 * @Author: JreamY
 * @Date: 2021/5/17
 **/
public class Request extends HashMap<String, Object> implements Serializable {

    // todo 可以再加额外的系统参数如：transactionId
}
