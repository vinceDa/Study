package com.ohyoung.demo.basic;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

class BasicTest {


    @Test
    public void other() {
        Car car = new Car("make", 5, "type1");
        Class<? extends Car> a = car.getClass();
        Field[] fields = a.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
    }

    @Test
    public void basic() {
        Car car = new Car("make", 5, "type1");
        CarMapper carMapper = CarMapper.INSTANCE;
        CarDto carDto = carMapper.carToCarDto(car);
        assert car.getMake().equals(carDto.getMake());
        assert car.getNumberOfSeats() == carDto.getSeatCount();
        assert car.getType().equals(carDto.getType());
    }

}