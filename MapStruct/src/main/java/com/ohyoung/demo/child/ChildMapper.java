package com.ohyoung.demo.child;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { SonMapper.class })
public interface ChildMapper {


    ChildMapper INSTANCE = Mappers.getMapper(ChildMapper.class);

    @Mapping(source = "sons", target = "sonDtos")
    FatherDto toDto(Father father);

    @Mapping(source = "sonDtos", target = "sons")
    void updateFather(FatherDto fatherDto, @MappingTarget Father father);

}
