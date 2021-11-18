package com.elec.controller;


import com.elec.dal.pojo.GameSession;
import com.elec.dal.pojo.PostInfo;
import com.elec.dto.valueObj.Result;
import com.elec.service.PostsSaveService;
import com.elec.service.UserSaveService;
import org.springframework.ui.Model;
import com.elec.service.GameSessionHandleService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Jinglin
 * @since 2021-10-08
 */
@Controller
@RequestMapping("/game-session")
public class GameSessionController {
    @Resource
    private UserSaveService userSaveService;
    @Resource
    private GameSessionHandleService gameSessionHandleService;
    @Resource
    private PostsSaveService postsSaveService;

    @RequestMapping("/inigame")
    public String test0shuyuan(Model model){
        List<GameSession> listgs = Result.succeed(this.gameSessionHandleService.getGameList()).getData().subList(0,5);
        model.addAttribute("gslist",listgs);
        GameSession gs = Result.succeed(this.gameSessionHandleService.getGameList()).getData().get(0);
        Long gameId = gs.getGameId();
        GameSession gs1 = Result.succeed(this.gameSessionHandleService.getDetail(gameId)).getData();
        model.addAttribute("gameSession",gs1);
        PostInfo list1 = Result.succeed(this.postsSaveService.getPostList()).getData().get(0);
        model.addAttribute("postlist1",list1);
        PostInfo list2 = Result.succeed(this.postsSaveService.getPostList()).getData().get(1);
        model.addAttribute("postlist2",list2);
        PostInfo list3 = Result.succeed(this.postsSaveService.getPostList()).getData().get(2);
        model.addAttribute("postlist3",list3);
        PostInfo list4 = Result.succeed(this.postsSaveService.getPostList()).getData().get(2);
        model.addAttribute("postlist4",list4);
        PostInfo list5 = Result.succeed(this.postsSaveService.getPostList()).getData().get(2);
        model.addAttribute("postlist5",list5);
        return "game";
    }
    @RequestMapping("/gameDetail")
    public String test1shuyuan(@RequestParam Long gameId, Model model)
    {
        List<GameSession> listgs = Result.succeed(this.gameSessionHandleService.getGameList()).getData().subList(0,5);
        model.addAttribute("gslist",listgs);
        GameSession gs1 = Result.succeed(this.gameSessionHandleService.getDetail(gameId)).getData();
        model.addAttribute("gameSession",gs1);
        PostInfo list1 = Result.succeed(this.postsSaveService.getPostList()).getData().get(0);
        model.addAttribute("postlist1",list1);
        PostInfo list2 = Result.succeed(this.postsSaveService.getPostList()).getData().get(1);
        model.addAttribute("postlist2",list2);
        PostInfo list3 = Result.succeed(this.postsSaveService.getPostList()).getData().get(2);
        model.addAttribute("postlist3",list3);
        PostInfo list4 = Result.succeed(this.postsSaveService.getPostList()).getData().get(2);
        model.addAttribute("postlist4",list4);
        PostInfo list5 = Result.succeed(this.postsSaveService.getPostList()).getData().get(2);
        model.addAttribute("postlist5",list5);
        model.addAttribute("length",gs1.getOddsInformation().split(",").length-1);
        return "game";
    }
}
