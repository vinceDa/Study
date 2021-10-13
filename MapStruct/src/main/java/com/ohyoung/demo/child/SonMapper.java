package com.ohyoung.demo.child;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SonMapper {


    SonMapper INSTANCE = Mappers.getMapper(SonMapper.class);

    @Mapping(source = "name", target = "dtoName")
    SonDto toDto(Son son);

    @Mapping(source = "dtoName", target = "name")
    Son toEntity(SonDto sonDto);

}
