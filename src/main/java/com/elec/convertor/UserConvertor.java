package com.elec.convertor;

import com.elec.component.GenerateId;
import com.elec.dal.pojo.GameSession;
import com.elec.dal.pojo.PostInfo;
import com.elec.dal.pojo.User;
import com.elec.dal.pojo.UserInfo;
import com.elec.dto.PostSaveDTO;
import com.elec.dto.UserSaveDTO;
import com.elec.dto.valueObj.US_Sports_Detail;
import com.elec.dto.valueObj.basketball.BasketDetail;
import com.elec.dto.valueObj.football.FootballDetail;
import com.elec.enums.GameTypeEnums;

import java.util.Date;

public class UserConvertor {
    public static User convert2User(UserSaveDTO userSaveDTO){
        User user = new User();
        user.setId(1);
        user.setUserId(GenerateId.getGeneratID());
        user.setUserName(userSaveDTO.getUserName());
        user.setPassword(userSaveDTO.getPassword());
        user.setEmail(userSaveDTO.getEmail());
        user.setPhoneNumber(userSaveDTO.getPhoneNumber());
        user.setGmtCreate(new Date());
        user.setGmtModified(new Date());
        return user;
    }
    public static UserInfo convert2UserInfo(User user){
        UserInfo userInfo = new UserInfo();
//        userInfo.setId(1);
        userInfo.setUserId(user.getUserId());
        userInfo.setUserName(user.getUserName());
        userInfo.setCurrScores(1000L);
        userInfo.setGmtCreate(new Date());
        userInfo.setGmtModified(new Date());
        return userInfo;
    }
    public static PostInfo convert2PostInfo(PostSaveDTO postSaveDTO){
        PostInfo postInfo = new PostInfo();
        postInfo.setUserName(postSaveDTO.getUserName());
        postInfo.setPostId(Long.parseLong(postSaveDTO.getPostId()));
        postInfo.setTitle(postSaveDTO.getTitle());
        postInfo.setContent(postSaveDTO.getContent());
        postInfo.setGameType(postSaveDTO.getGameType());
        postInfo.setComment(postSaveDTO.getComment());
        postInfo.setGmtCreate(new Date());
        postInfo.setGmtModified(new Date());
        return postInfo;
    }
    public static GameSession convert2GameSession(FootballDetail gameDetail){
        GameSession gameSession = new GameSession();
        gameSession.setGameId(gameDetail.getFixture().getId());
        gameSession.setGameType(GameTypeEnums.FOOTBALL.name());
        final long time = gameDetail.getFixture().getTimestamp().getTime();
        gameSession.setGameTime(new Date(time*1000));
//        gameSession.setGmtCreate(new Date());
//        gameSession.setGmtModified(new Date());
        gameSession.setHome(gameDetail.getTeams().getHome().getName());
        gameSession.setAway(gameDetail.getTeams().getAway().getName());
        gameSession.setLeague(gameDetail.getLeague().getName());
        gameSession.setOddsInformation(gameDetail.getFixture().getOddsInfo());
        gameSession.setGameResult(gameDetail.getScore().getFulltime().getHome()
                +":"+gameDetail.getScore().getFulltime().getAway());
        return gameSession;
    }
    public static GameSession convert2BasketballGameSession(BasketDetail detail){
        GameSession gameSession = new GameSession();
        gameSession.setGameId(detail.getId());
        gameSession.setGameType(GameTypeEnums.BASKETBALL.name());
        final long time = detail.getTimestamp().getTime();
        gameSession.setGameTime(new Date(time*1000));
        gameSession.setHome(detail.getTeams().getHome().getName());
        gameSession.setAway(detail.getTeams().getAway().getName());
        gameSession.setOddsInformation(detail.getOddsInfo());
        gameSession.setGameResult(detail.getScores().getHome().toString()
                +":"+detail.getScores().getAway().toString());
        return gameSession;
    }
    public static PostSaveDTO convert2PostSaveDTO(PostInfo postInfo){
        PostSaveDTO postSaveDTO = new PostSaveDTO();
        postSaveDTO.setPostId(postInfo.getPostId().toString());
        postSaveDTO.setUserName(postInfo.getUserName());
        postSaveDTO.setTitle(postInfo.getTitle());
        postSaveDTO.setGameType(postInfo.getGameType());
        postSaveDTO.setContent(postInfo.getContent());
        postSaveDTO.setComment(postInfo.getComment());
        return postSaveDTO;
    }

    public static GameSession convert2USGameSession(US_Sports_Detail gameDetail){
        try{
            GameSession gameSession = new GameSession();
            gameSession.setGameId(GenerateId.getGeneratID());
            gameSession.setGameType(GameTypeEnums.US_SPORTS.name());
            gameSession.setGameTime(gameDetail.getSchedule().getDate());
            gameSession.setGmtCreate(gameDetail.getOdds().get(0).getOpenDate());
            gameSession.setGmtModified(gameDetail.getLastUpdated());
            gameSession.setHome(gameDetail.getTeams().getHome().getTeam());
            gameSession.setAway(gameDetail.getTeams().getAway().getTeam());
            gameSession.setLeague(gameDetail.getDetails().getLeague());
            gameSession.setOddsInformation(gameDetail.getOdds().get(0).getSpread().getOpen().getAway() + " : " + gameDetail.getOdds().get(0).getSpread().getOpen().getHome());
            gameSession.setGameResult(gameDetail.getScoreboard().getScore().getAway() + " : " + gameDetail.getScoreboard().getScore().getHome());
            return gameSession;
        } catch (NullPointerException e) {
            System.out.println("Wait for today's competition data!");
            return null;
        }
    }

}
