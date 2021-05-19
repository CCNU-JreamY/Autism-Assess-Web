package cn.pavi.aaw.annotation;

import cn.pavi.aaw.config.postvalidator.enums.ValidatorEnum;

import java.lang.annotation.*;

/**
 * @Description: POST请求参数验证
 * @Author: JreamY
 * @Date: 2021/5/17
 **/
@Documented
@Target(ElementType.METHOD)
@Repeatable(PostValidators.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface PostValidator {

    /**
     * 校验的参数列表
     *
     * @return
     */
    String[] params();

    /**
     * 校验方式
     */
    ValidatorEnum validator() default ValidatorEnum.REQUIRED;

    /**
     * 自定义正则校验方式时填入正则
     */
    String pattern() default "";

}
