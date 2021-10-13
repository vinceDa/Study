package com.ohyoung.dp;

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.IdcardUtil;

import javax.xml.bind.ValidationException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ohYoung
 * @date 2021/9/13 0:36
 */
public class IdCard {

    private String idCard;

    public IdCard(String idCard) throws ValidationException {
        if (CharSequenceUtil.isEmpty(idCard)) {
            throw new ValidationException("身份证号不能为空");
        } else if (!IdcardUtil.isValidCard18(idCard)) {
            throw new ValidationException("身份证号格式错误");
        }
        this.idCard = idCard;
    }

    public Date getBirthDay() throws ParseException {
        String birth = idCard.substring(6, 14);
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.parse(birth);
    }

    public Integer getSex() {
        return idCard.charAt(16) % 2 == 0 ? 0 : 1;
    }

}
