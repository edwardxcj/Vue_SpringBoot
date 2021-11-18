package com.elec.controller.webController;

import com.alibaba.fastjson.JSONObject;
import com.elec.dto.ModifyWatchListDTO;
import com.elec.dto.UserSaveDTO;
import com.elec.dto.valueObj.Result;
import com.elec.service.UserSaveService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/save/userInfo")
public class UserSaveController {
    @Resource
    private UserSaveService userSaveService;

    /**
     * 保存用户信息
     * @param userSaveDTO
     * @return
     */
    @PostMapping("/saveUserInfo")
    public Result<?> saveUserInfo(@RequestBody UserSaveDTO userSaveDTO){
        JSONObject object = new JSONObject();
        object.fluentPut("message",this.userSaveService.saveUserInfo(userSaveDTO));
        return Result.succeed(object);
    }

    /**
     * 判断登录是否成功
     * @param userSaveDTO
     * @return
     */
    @PostMapping("/userLogin")
    public Result<?> userLogin(@RequestBody UserSaveDTO userSaveDTO){
        return Result.succeed(this.userSaveService.userLogin(userSaveDTO));
    }

    /**
     * 获取用户信息详情（积分、帖子等）
     * @param userId
     * @return
     */
    @GetMapping("/queryUserInfo")
    public Result<?> queryUserInfo(@RequestParam(value = "userId") String userId){
        return Result.succeed(this.userSaveService.queryUserInfo(userId));
    }
    /**
     * 获取关注用户列表
     */
    @PostMapping("/updateWatchList")
    public Result<?> updateWatchList(@RequestBody ModifyWatchListDTO modifyWatchListDTO){
        return Result.succeed();
    }

    /**
     * 修改用户密码
     * @param userName
     * @return
     */
    @GetMapping("/modifyPassword")
    public Result<?> modifyPassword(@RequestParam(value = "userName")String userName,
                                     @RequestParam(value = "password")String password){

        return Result.succeed(this.userSaveService.modifyPassword(userName,password));
    }
}
