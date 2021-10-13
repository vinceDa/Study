package com.ohyoung.demo.basic;

import org.junit.jupiter.api.Test;

class BasicTest {

    @Test
    public void other() {
        System.out.println("md_House#AreaBuilding*md_House#ElevatorFloorFactor*fc_FeeStandard#Price".length());
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