package com.ohyoung.demo.ywy;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerAssembler {

    CustomerAssembler INSTANCE = Mappers.getMapper(CustomerAssembler.class);

    CustomerDto toDTO(Customer customer);

    Customer toEntity(CustomerSaveCommand command);
}
