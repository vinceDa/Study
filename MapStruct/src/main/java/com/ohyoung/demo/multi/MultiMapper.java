package com.ohyoung.demo.multi;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MultiMapper {


    MultiMapper INSTANCE = Mappers.getMapper(MultiMapper.class);

    @Mapping(source = "father.name", target = "name")
    @Mapping(source = "son.name", target = "sonName")
    FatherDto toDto(Father father, Son son);

}
