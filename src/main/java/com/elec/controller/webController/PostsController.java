package com.elec.controller.webController;

import com.alibaba.fastjson.JSONObject;
import com.elec.dto.PostSaveDTO;
import com.elec.dto.valueObj.Result;
import com.elec.service.PostsSaveService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/save/post")
public class PostsController {
    @Resource
    private PostsSaveService postsSaveService;
    //发帖帖子入库
    @PostMapping("/savePost")
    public Result<?> savePost(@RequestBody PostSaveDTO postSaveDTO){
        return Result.succeed(this.postsSaveService.savePostInfo(postSaveDTO));
    }
    //获取帖子详情
    @GetMapping("/getPostDetail")
    public Result<?> getPostDetail(@RequestParam(value = "postId") String postId){
        PostSaveDTO postSaveDTO= this.postsSaveService.queryPostInfoById(postId);
        return Result.succeed(postSaveDTO);
    }
    //更新帖子信息
    @PostMapping("/updatePostInfo")
    public Boolean updatePostInfo(){
        return true;
    }
    //获取帖子列表
    @PostMapping("/getPostList")
    public Result<?> getPostList(){
        return Result.succeed(this.postsSaveService.getPostList());
    }
}

