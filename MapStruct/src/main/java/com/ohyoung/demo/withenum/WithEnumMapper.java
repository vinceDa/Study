package com.ohyoung.demo.withenum;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WithEnumMapper {

    WithEnumMapper INSTANCE = Mappers.getMapper(WithEnumMapper.class);

    @Mappings({
        @Mapping(source = "numberOfSeats", target = "seatCount"),
        @Mapping(target = "type", expression = "java(withEnum.enum2Int())")
    })
    WithEnumDto toDto(WithEnum withEnum);


    @Mappings({
        @Mapping(source = "seatCount", target = "numberOfSeats")
    })
    WithEnum toEnum(WithEnumDto withEnumDto);

}
