package com.ohyoung.aop.customize;

import com.ohyoung.aop.annotation.ControllerWebLog;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author ouyb01
 * @date 2022/6/21 11:32
 */
public class LogRecordPointCut extends StaticMethodMatcherPointcut implements Serializable {

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        // 解析 这个 method 上有没有 @LogRecordAnnotation 注解，有的话会解析出来注解上的各个参数
        // 查找类上@ControllerWebLog注解属性
        AnnotationAttributes attributes = AnnotatedElementUtils.findMergedAnnotationAttributes(
                targetClass, ControllerWebLog.class, false, false);
        if (Objects.nonNull(attributes)) {
            return true;
        }
        ControllerWebLog annotation = method.getAnnotation(ControllerWebLog.class);
        // 查找方法上@SystemLog注解属性
        attributes = AnnotatedElementUtils.findMergedAnnotationAttributes(
                method, ControllerWebLog.class, false, false);
        return Objects.nonNull(attributes);
    }

}
