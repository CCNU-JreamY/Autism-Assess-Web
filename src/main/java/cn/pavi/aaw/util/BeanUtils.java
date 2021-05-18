package cn.pavi.aaw.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @Description: Bean获取工具类
 * @Author: JreamY
 * @Date: 2021/5/18
 **/
public class BeanUtils implements ApplicationContextAware {

    private BeanUtils() {
    }

    private final static BeanUtils instance;

    static {
        instance = new BeanUtils();
    }

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        return instance.applicationContext.getBean(clazz);
    }

    public static <T> T getBean(String beanName, Class<T> clazz) {
        return instance.applicationContext.getBean(beanName, clazz);
    }
}
