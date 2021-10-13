package com.ohyoung.demo.child;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 *
 */
@Data
@AllArgsConstructor
public class FatherDto {

    private String name;

    private List<SonDto> sonDtos;

}
