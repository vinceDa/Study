package com.ohyoung.demo.withenum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class WithEnumDto {
    private String make;
    private int seatCount;
    private Integer type;

    public void setType(EnumType enumType) {
        this.type = enumType.getType();
    }
}
