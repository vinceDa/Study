package com.ohyoung.demo.withenum;

public enum EnumType {

    FIRST(1), SECOND(2), THIRD(3);

    private final Integer type;

    EnumType(Integer type) {
        this.type = type;
    }

    public static EnumType convert(Integer type) {
        switch (type) {
            case 1:
                return FIRST;
            case 2:
                return SECOND;
            case 3:
                return THIRD;
            default:
                return null;
        }
    }

    public Integer getType() {
        return this.type;
    }
}
