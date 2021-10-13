package com.ohyoung.demo.withenum;

import lombok.Data;

@Data
public class WithEnum {

    private String make;
    private int numberOfSeats;
    private EnumType type;

    public void setType(Integer type) {
        this.type = EnumType.convert(type);
    }

}
