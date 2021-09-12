package com.ohyoung.dp;

import lombok.Data;

import java.util.Date;

/**
 * @author ohYoung
 * @date 2021/9/12 23:27
 */
@Data
public class Customer {

    private String customerGUID;

    private String name;

    private Integer sex;

    private Date birthDay;

    private String idCard;

    private String phone;

    private String address;

}
