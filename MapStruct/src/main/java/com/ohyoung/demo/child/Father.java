package com.ohyoung.demo.child;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 *
 */
@Data
@AllArgsConstructor
public class Father {

    private String name;

    private List<Son> sons;

}
