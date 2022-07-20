package com.ohyoung.aop;

import com.ohyoung.aop.customize.LogRecordInterceptor;
import com.ohyoung.aop.customize.LogRecordPointCut;
import com.ohyoung.aop.customize.LogRecordPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ouyb01
 * @date 2022/6/21 11:56
 */
@Configuration
public class Config {

    @Bean
    public LogRecordPointCut logRecordPointCut() {
        return new LogRecordPointCut();
    }

    /**
     * 定义切面
     */
    @Bean
    public LogRecordPointcutAdvisor logRecordPointcutAdvisor() {
        LogRecordPointcutAdvisor advisor = new LogRecordPointcutAdvisor();
        advisor.setLogRecordPointCut(logRecordPointCut());
        advisor.setAdvice(logRecordInterceptor());
        return advisor;
    }

    /**
     * 定义通知
     *
     * @return
     */
    @Bean
    public LogRecordInterceptor logRecordInterceptor() {
        return new LogRecordInterceptor();
    }
}
