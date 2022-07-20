package com.ohyoung.aop.customize;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractBeanFactoryPointcutAdvisor;
import org.springframework.stereotype.Component;

/**
 * 切面
 * @author ouyb01
 * @date 2022/6/21 11:34
 */
public class LogRecordPointcutAdvisor extends AbstractBeanFactoryPointcutAdvisor {

    private LogRecordPointCut logRecordPointCut;

    @Override
    public Pointcut getPointcut() {
        return logRecordPointCut;
    }

    public void setLogRecordPointCut(LogRecordPointCut logRecordPointCut) {
        this.logRecordPointCut = logRecordPointCut;
    }

}
