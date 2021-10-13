package com.ohyoung.demo.withenum;


import org.junit.jupiter.api.Test;

public class WithEnumTest {

    @Test
    public void withEnum() {
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
}