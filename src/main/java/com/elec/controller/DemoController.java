package com.elec.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("elec/outTake")
public class DemoController {

    @RequestMapping("/test")
    public String test(){
        return "启动成功";
    }

}
