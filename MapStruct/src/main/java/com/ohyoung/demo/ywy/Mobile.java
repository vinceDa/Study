package com.ohyoung.demo.ywy;

public class Mobile {

    private final String mobile;

    public String getMobile() {
        return mobile;
    }

    public Mobile(String mobile) {
        if (mobile != null && isValid(mobile)) {
            System.out.println("手机号码格式错误");
        }
        this.mobile = mobile;
    }

    public boolean isValid(String mobile) {
        String pattern = "(?:0|86|\\+86)?1[3-9]\\d{9}";
        return mobile.matches(pattern);
    }

}
