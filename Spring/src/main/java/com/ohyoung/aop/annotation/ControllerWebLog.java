package com.ohyoung.aop.annotation;

import java.lang.annotation.*;

/**
 * @author ouyb01
 * @date 2022/6/21 10:24
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ControllerWebLog {
    /**
     * 接口名称
     */
    String name();

    /**
     * 是否需要持久化
     */
    boolean intoDb() default false;

}
