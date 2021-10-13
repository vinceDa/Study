package com.ohyoung.demo.ywy;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class CustomerDto {
    private UUID customerGUID;
    private UUID globalCustomerGUID;
    private String customerType;
    private UUID projectGUID;
    private String customerName;
    private String linkman;
    private String mobile;
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
    private String tel1;
    private String tel2;
    private String email;
    private String wxNumber;
    private String qqNumber;
    private String companyName;
    private String companyPhone;
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

    public void setMobile(Mobile mobile) {
        this.mobile = mobile.getMobile();
    }

    public void setTel1(Mobile tel1) {
        this.tel1 = tel1.getMobile();
    }

    public void setTel2(Mobile tel2) {
        this.tel2 = tel2.getMobile();
    }

    public void setCompanyPhone(Mobile companyPhone) {
        this.companyPhone = companyPhone.getMobile();
    }
}
