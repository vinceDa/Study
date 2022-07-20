package com.ohyoung;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yanghui
 */
@SpringBootApplication(scanBasePackages = "com.ohyoung")
public class SpringApplication {

    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(SpringApplication.class,args);
    }

}
