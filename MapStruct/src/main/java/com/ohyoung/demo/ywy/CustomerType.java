package com.ohyoung.demo.ywy;

public enum CustomerType {

    PERSON("个人", "CustType_Person"), COMPANY("公司", "CustType_Company");

    String text;

    String value;

    CustomerType(String text, String value) {
        this.text = text;
        this.value = value;
    }

    String getValue() {
        return this.value;
    }

    public static CustomerType convertByText(String text) {
        switch (text) {
            case "个人":
                return PERSON;
            case "公司":
                return COMPANY;
            default:
                System.out.println("错误的客户类型");
                return null;
        }
    }

    public static CustomerType convertByValue(String value) {
        switch (value) {
            case "CustType_Person":
                return PERSON;
            case "CustType_Company":
                return COMPANY;
            default:
                System.out.println("错误的客户类型");
                return null;
        }
    }

}
