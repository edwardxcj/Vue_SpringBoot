package com.elec.api;

import com.alibaba.fastjson.JSONObject;
import com.elec.component.MD5Utils;
import com.elec.dal.pojo.UserInfo;
import com.elec.devTest.BaseTest;
import com.elec.dto.PostSaveDTO;
import com.elec.enums.GameTypeEnums;
import com.elec.service.PostsSaveService;
import com.elec.service.RankListService;
import com.elec.service.UserSaveService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class UserTest extends BaseTest {
    @Resource
    private UserSaveService userSaveService;
    @Resource
    private RankListService rankListService;
    @Resource
    private PostsSaveService postsSaveService;
    @Test
    public void test1(){
        String userName = "nanmenamenmandsa";
        String password = "llluuuulluuu";
        this.userSaveService.modifyPassword(userName,password);
    }
    @Test
    public void test22(){
        final List<UserInfo> userInfoList = this.rankListService.getUserInfoList();
        System.out.println(JSONObject.toJSONString(userInfoList));
    }
    @Test
    public void testMd5(){
        String password = "llluuuulluuu";
        final String s = MD5Utils.stringToMD5(password);
        System.out.println(s.equals("7739a8c2ec03467b7e75660cf6ba9cd0"));
    }
    @Test
    public void testM1235(){
        PostSaveDTO postSaveDTO = new PostSaveDTO();
        postSaveDTO.setGameType(GameTypeEnums.FOOTBALL.name());
        postSaveDTO.setUserName("usernamelululu1wo");
        postSaveDTO.setTitle("this is title");
        postSaveDTO.setContent("this is content");
        postSaveDTO.setComment("this is comment");
        this.postsSaveService.savePostInfo(postSaveDTO);
    }
}
