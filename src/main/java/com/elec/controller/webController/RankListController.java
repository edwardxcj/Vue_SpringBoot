package com.elec.controller.webController;

import com.elec.dal.pojo.UserInfo;
import com.elec.service.RankListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/rank/list")
public class RankListController {
    @Resource
    private RankListService rankListService;
    //实时用户积分排名
    @PostMapping("/getRankList")
    public List<UserInfo> getRankList(){
        return this.rankListService.getUserInfoList();
    }
    //
    //
    //
}
