package com.ohyoung.aop.customize;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author ouyb01
 * @date 2022/6/21 11:35
 */
public class LogRecordInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println(invocation.getMethod().toGenericString());
        System.out.println(Arrays.toString(invocation.getArguments()));
        return invocation;
    }
}
