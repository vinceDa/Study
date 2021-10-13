package com.ohyoung.demo.child;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ChildMapperTest {

    @Test
    public void test() {
        List<Son> sons = new ArrayList<>();
        sons.add(new Son("1", "son1"));
        sons.add(new Son("2", "son2"));
        sons.add(new Son("3", "son3"));
        Father father = new Father("father", sons);
        ChildMapper instance = ChildMapper.INSTANCE;
        FatherDto fatherDto = instance.toDto(father);
        assert fatherDto.getSonDtos().get(0).getDtoName().equals(father.getSons().get(0).getName());
    }

    @Test
    public void update() {
        List<Son> sons = new ArrayList<>();
        sons.add(new Son("1", "son1"));
        sons.add(new Son("2", "son2"));
        sons.add(new Son("3", "son3"));
        Father father = new Father("father", sons);


        List<SonDto> sonDtos = new ArrayList<>();
        sonDtos.add(new SonDto("1", "son4"));
        sonDtos.add(new SonDto("2", "son5"));
        sonDtos.add(new SonDto("3", "son6"));
        FatherDto fatherDto = new FatherDto("father", sonDtos);

        ChildMapper instance = ChildMapper.INSTANCE;
        instance.updateFather(fatherDto, father);
        System.out.println(father.toString());
    }

}