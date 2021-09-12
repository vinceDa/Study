package com.ohyoung.example;

import cn.hutool.core.lang.PatternPool;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.CharUtil;
import cn.hutool.core.util.IdcardUtil;
import cn.hutool.core.util.ReUtil;
import com.ohyoung.dp.Customer;

import javax.xml.bind.ValidationException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ohYoung
 * @date 2021/9/12 23:25
 */
public class TraditionalCode {

    public void updateCustomerIdCard(String customerGUID, String idCard) throws ValidationException, ParseException {
        // 假如此处需要将参数的具体错误信息返回, 所有这样写的代码都需要改动
        if (CharSequenceUtil.isEmpty(customerGUID) || !Validator.isUUID(customerGUID)) {
            throw new ValidationException("customerGUID");
        }
        if (CharSequenceUtil.isEmpty(idCard) || !IdcardUtil.isValidCard18(idCard)) {
            throw new ValidationException("idCard");
        }
        String birth = idCard.substring(6, 14);
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date parse = format.parse(birth);
        // 第17位数为奇数是男性, 偶数为女性
        int sex = idCard.charAt(16) % 2 == 0 ? 0 : 1;
        Customer customer = new Customer();
        customer.setCustomerGUID(customerGUID);
        customer.setIdCard(idCard);
        customer.setSex(sex);
        customer.setBirthDay(parse);
        System.out.println("insert success: " + customer.toString());
    }


}
