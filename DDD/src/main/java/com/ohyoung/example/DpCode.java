package com.ohyoung.example;

import com.ohyoung.dp.CustomerGUID;
import com.ohyoung.dp.DpCustomer;
import com.ohyoung.dp.IdCard;

import javax.xml.bind.ValidationException;
import java.text.ParseException;

/**
 * @author ohYoung
 * @date 2021/9/12 23:25
 */
public class DpCode {

    public void updateCustomerIdCard(CustomerGUID customerGUID, IdCard idCard) throws ParseException {
        DpCustomer customer = new DpCustomer();
        customer.setCustomerGUID(customerGUID);
        customer.setIdCard(idCard);
        customer.setSex(idCard.getSex());
        customer.setBirthDay(idCard.getBirthDay());
        System.out.println("insert success: " + customer.toString());
    }


}
