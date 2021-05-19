package cn.pavi.aaw.annotation;

import java.lang.annotation.*;

/**
 * repeat postValidator annotation
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PostValidators {

    PostValidator[] value();
}
