package cn.pavi.aaw.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 日志打印工具类
 * @Author: JreamY
 * @Date: 2021/5/16
 **/
public class LogUtils {

    private LogUtils() {
    }

    private static Map<Class, Logger> container;

    private static Logger ERROR_LOG = LoggerFactory.getLogger("error");
    private static Logger INTER_LOG = LoggerFactory.getLogger("interface");

    static {
        container = new HashMap<>(64);
    }


    public static void info(Class clazz, String pattern, Object... params) {
        getLogger(clazz).info(pattern, params);
    }

    public static void inter(String pattern, Object... params) {
        INTER_LOG.info(pattern, params);
    }

    public static void error(String pattern, Object... params) {
        ERROR_LOG.error(pattern, params);
    }

    private static Logger getLogger(Class clazz) {
        Logger logger = container.get(clazz);
        if (logger == null) {
            container.put(clazz, logger = newLogger(clazz));
        }
        return logger;
    }

    private static Logger newLogger(Class clazz) {
        return LoggerFactory.getLogger(clazz);
    }

}
