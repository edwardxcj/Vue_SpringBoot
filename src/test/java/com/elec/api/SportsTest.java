package com.elec.api;

import com.alibaba.fastjson.JSONObject;
import com.elec.dal.pojo.GameSession;
import com.elec.dal.pojo.UserInfo;
import com.elec.devTest.BaseTest;
import com.elec.dto.GameBetDTO;
import com.elec.dto.UpdateGameDetailDTO;
import com.elec.dto.UserSaveDTO;
import com.elec.service.GameSessionHandleService;
import com.elec.service.UserSaveService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class SportsTest extends BaseTest {
    @Resource
    private UserSaveService userSaveService;
    @Resource
    private GameSessionHandleService gameSessionHandleService;
    @Test
    public void test2() throws Exception {
        UserSaveDTO userSaveDTO = new UserSaveDTO();
        userSaveDTO.setPassword("ceshiyixia");
        userSaveDTO.setEmail("wowoyoulaileabb@email.com");
        userSaveDTO.setUserName("usernamelululu1wo");
        userSaveDTO.setPhoneNumber("181321wqeqw22");
        this.userSaveService.saveUserInfo(userSaveDTO);
    }
    @Test
    public void test3(){
        String userName = "username*1wo";
        UserInfo userInfo = this.userSaveService.queryUserInfo(userName);
        System.out.println(JSONObject.toJSONString(userInfo));

    }
    @Test
    public void test4(){
        this.gameSessionHandleService.saveDetail();
    }
    @Test
    public void test2222(){
        UpdateGameDetailDTO updateGameDetailDTO = new UpdateGameDetailDTO();
        List<String> list = new ArrayList<>();
        String s = "710627";
        list.add(s);
        updateGameDetailDTO.setGameId(list);
        this.gameSessionHandleService.updateGameDetail(updateGameDetailDTO);
    }
    @Test
    public void test22(){
        UserSaveDTO userSaveDTO = new UserSaveDTO();
        userSaveDTO.setUserName("usernamelululu1wo");
        userSaveDTO.setPassword("ceshiyixia");
        System.out.println(this.userSaveService.userLogin(userSaveDTO));
    }
    @Test
    public void test213(){
        final List<GameSession> gameList = this.gameSessionHandleService.getGameList();
        System.out.println(JSONObject.toJSONString(gameList));
    }
//    @Test
//    public void test21312312(){
//        String sss = "{\n" +
//                "                paidScore: 100,\n" +
//                "                userName: \"qqq\",\n" +
//                "                userId: 1020094254486841,\n" +
//                "                gameId: 1018080618093594,\n" +
//                "                comment: \"200\",\n" +
//                "                victoryOrDefeat: \"VICTORY\",\n" +
//                "            }";
//        final GameBetDTO gameBetDTO = JSONObject.parseObject(sss, GameBetDTO.class);
//        this.gameSessionHandleService.saveUserOperation(gameBetDTO);
//    }
}
