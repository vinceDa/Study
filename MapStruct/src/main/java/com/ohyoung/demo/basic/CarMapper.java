package com.ohyoung.demo.basic;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper( CarMapper.class );

    @Mapping(target = "seatCount", constant = "998")
    CarDto carToCarDto(Car car);

}
