package cn.pavi.aaw.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 参数相关工具类
 * @Author: JreamY
 * @Date: 2021/4/24
 **/
public class ParamUtils {

    private final static Logger LOGGER = LoggerFactory.getLogger(ParamUtils.class);

    private ParamUtils() {
    }

    /**
     * 参数非空校验，字符串类型长度校验
     *
     * @param params
     * @return
     */
    public static boolean paramCheckNull(Object... params) {

        int idx = 0;
        for (Object param : params) {
            idx++;
            if (param == null || (param.getClass() == String.class && ((String)param).length() <= 0)) {
                LOGGER.info("param index -> {} is invalid", idx);
                return true;
            }
        }
        return false;
    }

}
