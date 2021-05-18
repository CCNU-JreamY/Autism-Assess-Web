package cn.pavi.aaw.util;

import cn.pavi.aaw.bean.exception.SystemException;

/**
 * @Description: 断言工具类
 * @Author: JreamY
 * @Date: 2021/5/18
 **/
public class AssertUtils {

    private AssertUtils() {
    }

    private static SystemException exception;

    static {
        exception = new SystemException("参数错误", "参数错误");
    }

    public static void mustNotNull(String... params) {
        for (String param : params) {
            if (param == null) {
                throw exception;
            }
        }
    }

}
