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
    private String usedName;
    private String customerCode;
    private String cardType;
    private String cardNo;
    private String sex;
    private String marriageStatus;
    private String customerImportant;
    private String urgencyLinkman;
    private String urgencyTel;
    private String remark;
    private Mobile tel1;
    private Mobile tel2;
    private String email;
    private String wxNumber;
    private String qqNumber;
    private String companyName;
    private Mobile companyPhone;

    private String addressSplicing;
    private String addressProvinceId;
    private String addressProvinceName;
    private String addressCityId;
    private String addressCityName;
    private String addressProperId;
    private String addressProperName;
    private String addressDetail;

    private String industry;
    private String lealPerson;
    private String businessScope;
    private Date birthday;
    private String nationality;
    private String customerLabel;
    private String educationLevel;
    private String nativePlace;
    private String job;
    private String socialNature;
    private String interests;
    private String masterDataCode;
    private String attachment;

    public void setCustomerType(String customerType) {
        this.customerType = CustomerType.convertByValue(customerType);
    }

    public void setMobile(String mobile) {
        this.mobile = new Mobile(mobile);
    }

    public void setTel1(String tel1) {
        this.tel1 = new Mobile(tel1);
    }

    public void setTel2(String tel2) {
        this.tel2 = new Mobile(tel2);
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = new Mobile(companyPhone);
    }
}
