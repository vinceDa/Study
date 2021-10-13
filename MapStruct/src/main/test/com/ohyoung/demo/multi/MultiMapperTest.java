package com.ohyoung.demo.multi;

import org.junit.jupiter.api.Test;

class MultiMapperTest {

    @Test
    public void multiMapperTest() {
        MultiMapper instance = MultiMapper.INSTANCE;
        Father father = new Father("father");
        Son son = new Son("son");
        FatherDto fatherDto = instance.toDto(father, son);
        assert fatherDto.getSonName().equals(son.getName());
    }

}