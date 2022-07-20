package com.ohyoung.aop.annotation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ouyb01
 * @date 2022/6/21 10:29
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/getOne")
    @ControllerWebLog(name = "查询", intoDb = true)
    public String getOne(Long id, String name) {
        return "1234";
    }
}

