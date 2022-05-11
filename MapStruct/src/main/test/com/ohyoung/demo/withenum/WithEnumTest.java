package com.ohyoung.demo.withenum;


import org.junit.jupiter.api.Test;

public class WithEnumTest {

    @Test
    public void enum2Int() {
        WithEnum withEnum = new WithEnum();
        withEnum.setMake("make");
        withEnum.setNumberOfSeats(5);
        withEnum.setType(EnumType.FIRST.getType());
        WithEnumMapper instance = WithEnumMapper.INSTANCE;
        WithEnumDto withEnumDto = instance.toDto(withEnum);
        assert withEnumDto.getMake().equals(withEnum.getMake());
        assert withEnumDto.getSeatCount() == withEnum.getNumberOfSeats();
        assert withEnumDto.getType().equals(withEnum.getType().getType());
    }

    @Test
    public void int2Enum() {
        WithEnumDto enumDto = new WithEnumDto();
        enumDto.setMake("make");
        enumDto.setSeatCount(5);
        enumDto.setType(1);
        WithEnumMapper instance = WithEnumMapper.INSTANCE;
        WithEnum withEnum = instance.toEnum(enumDto);
        assert withEnum.getMake().equals(enumDto.getMake());
        assert withEnum.getNumberOfSeats() == enumDto.getSeatCount();
        assert withEnum.getType().getType().equals(enumDto.getType());
    }
}