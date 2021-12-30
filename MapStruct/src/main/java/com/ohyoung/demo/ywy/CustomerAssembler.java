package com.ohyoung.demo.ywy;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerAssembler {

    CustomerAssembler INSTANCE = Mappers.getMapper(CustomerAssembler.class);

    CustomerDto toDTO(Customer customer);

    @Mappings({
            @Mapping(target = "mobile", expression = "java(new Mobile(command.getMobile()))")
    })
    Customer toEntity(CustomerSaveCommand command);
}
