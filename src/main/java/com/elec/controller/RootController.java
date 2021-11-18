package com.elec.controller;

import com.elec.service.GameSessionHandleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ok接口
 *
 * @author tengsimin
 * @version 2020/6/28 下午5:33
 */
@Controller
public class RootController {
    @Resource
    private GameSessionHandleService gameSessionHandleService;

    @GetMapping("/")
    public String root() {
//        this.gameSessionHandleService.saveBasketballDetail();
//        this.gameSessionHandleService.saveUSGameDetail();
        return "index";
    }

    @GetMapping("/ok")
    public String ok() {
        return "ok";
    }
}