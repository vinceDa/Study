package com.ohyoung.demo.withenum;

import lombok.Data;

@Data
public class WithEnumDto {
    private String make;
    private int seatCount;
    private Integer type;

    public void getType(EnumType enumType) {
        this.type = enumType.getType();
    }
}
