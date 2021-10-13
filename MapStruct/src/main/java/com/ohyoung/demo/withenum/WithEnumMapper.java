package com.ohyoung.demo.withenum;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WithEnumMapper {

    WithEnumMapper INSTANCE = Mappers.getMapper(WithEnumMapper.class);

    @Mapping(source = "numberOfSeats", target = "seatCount")
    WithEnumDto toDto(WithEnum withEnum);

}
