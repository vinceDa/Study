package com.ohyoung.dp;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.text.CharSequenceUtil;

import javax.xml.bind.ValidationException;

/**
 * @author ohYoung
 * @date 2021/9/13 0:36
 */
public class CustomerGUID {

    private String customerGUID;

    public CustomerGUID(String customerGUID) throws ValidationException {
        if (CharSequenceUtil.isEmpty(customerGUID) || !Validator.isUUID(customerGUID)) {
            throw new ValidationException("param is not a UUID type");
        }
        this.customerGUID = customerGUID;
    }
}
