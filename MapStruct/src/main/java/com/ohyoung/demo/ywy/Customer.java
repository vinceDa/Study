package com.ohyoung.demo.ywy;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class Customer {
    private UUID customerGUID;
    private CustomerType customerType;
    private UUID projectGUID;
    private String customerName;
    private String linkman;
    private Mobile mobile;

    public Mobile str2Mobile(String mobile) {
        this.setMobile(new Mobile(mobile));
        return this.mobile;
    }
}
