package com.elec.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.elec.api.HttpRequestA;
import com.elec.component.DateGetComponent;
import com.elec.dal.pojo.GameSession;
import com.elec.dal.pojo.OperationRecord;
import com.elec.dal.pojo.UserInfo;
import com.elec.dto.GameBetDTO;
import com.elec.dto.UpdateGameDetailDTO;
import com.elec.dto.valueObj.Result_V2;
import com.elec.dto.valueObj.US_Sports_Detail;
import com.elec.dto.valueObj.basketball.BasketDetail;
import com.elec.dto.valueObj.basketball.BasketballResult;
import com.elec.dto.valueObj.football.FirstLevel;
import com.elec.dto.valueObj.football.FootballDetail;
import com.elec.dto.valueObj.football.FootballResult;
import com.elec.enums.GameVictoryOrDefeatEnums;
import com.elec.enums.UserOperationEnums;
import com.elec.repository.GameSessionRepository;
import com.elec.repository.UserRepository;
import com.elec.service.GameSessionHandleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class GameSessionHandleServiceImpl implements GameSessionHandleService {
    @Resource
    private GameSessionRepository gameSessionRepository;

    @Resource
    private UserRepository userRepository;
    private final String date = DateGetComponent.getCurrentDate();

    private final HttpHeaders headers = new HttpHeaders();
    @Override
    public GameSession getDetail(Long gameId) {
        GameSession gameSession = this.gameSessionRepository.getDetailById(gameId);
        return gameSession;
    }

    @Override
    public boolean saveDetail() {
        String uri = "https://api-football-v1.p.rapidapi.com/v3/fixtures?date="+date+"&league=39&season=2021";
//        HttpHeaders headers = new HttpHeaders();
        headers.add("x-rapidapi-host","api-football-v1.p.rapidapi.com");
        headers.add("x-rapidapi-key","77bb1ccd20mshed85a95ffefdbebp187d43jsn4773d71cca23");
        ResponseEntity<String> result = HttpRequestA.getResult(headers, uri);
        FirstLevel<?> result1 = JSONObject.parseObject(result.getBody(),FirstLevel.class);
        if (null != result1){
            final Object data = result1.getResponse();
            JSONArray array = JSONObject.parseArray(JSONObject.toJSONString(data));
            List<FootballDetail> list = array.toJavaList(FootballDetail.class);
            list.forEach(l->{
                Long id = l.getFixture().getId();
                String uri1 = "https://api-football-v1.p.rapidapi.com/v3/odds?fixture="+id.toString()+"&bookmaker=6";
                ResponseEntity<String> result2 = HttpRequestA.getResult(headers, uri1);
                FirstLevel<?> result3 = JSONObject.parseObject(result2.getBody(),FirstLevel.class);
                if (null !=result3){
                    final Object response = result3.getResponse();
                    JSONArray array1 = JSONObject.parseArray(JSONObject.toJSONString(response));
                    List<FootballResult> list1 = array1.toJavaList(FootballResult.class);
                    String win = list1.get(0).getBookmakers().get(0).getBets().get(0).getValues().get(0).getOdd();
                    String draw = list1.get(0).getBookmakers().get(0).getBets().get(0).getValues().get(1).getOdd();
                    String lose = list1.get(0).getBookmakers().get(0).getBets().get(0).getValues().get(2).getOdd();
                    l.getFixture().setOddsInfo(win+":/"+draw+":/"+lose+":");
                }
            });
            this.gameSessionRepository.saveFootballGameDetail(list);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean saveBasketballDetail() {
        String uri = "https://api-basketball.p.rapidapi.com/games?season=2021-2022&league=12&date="+date;
        headers.add("x-rapidapi-host","api-basketball.p.rapidapi.com");
        headers.add("x-rapidapi-key","77bb1ccd20mshed85a95ffefdbebp187d43jsn4773d71cca23");
        ResponseEntity<String> result = HttpRequestA.getResult(headers, uri);
        FirstLevel<?> result1 = JSONObject.parseObject(result.getBody(),FirstLevel.class);
        if (null!=result1){
            final Object response = result1.getResponse();
            JSONArray array = JSONObject.parseArray(JSONObject.toJSONString(response));
            List<BasketDetail> list = array.toJavaList(BasketDetail.class);
            list.forEach(l->{
                Long id = l.getId();
                String uri1 = "https://api-basketball.p.rapidapi.com/odds?league=12&season=2021-2022&game="+id+"&bookmaker=27&bet=1";
                ResponseEntity<String> result2 = HttpRequestA.getResult(headers, uri1);
                FirstLevel<?> result11 = JSONObject.parseObject(result.getBody(),FirstLevel.class);
                if (null!=result11){
                    final Object o = result11.getResponse();
                    JSONArray array1 = JSONObject.parseArray(JSONObject.toJSONString(o));
                    List<BasketballResult> list1 = array1.toJavaList(BasketballResult.class);
                    String win = list1.get(0).getBookmakers().get(0).getBets().get(0).getValues().get(0).getOdd();
                    String draw = list1.get(0).getBookmakers().get(0).getBets().get(0).getValues().get(1).getOdd();
                    String lose = list1.get(0).getBookmakers().get(0).getBets().get(0).getValues().get(2).getOdd();
                    l.setOddsInfo(win+":/"+draw+":/"+lose+":");
                }
            });
            this.gameSessionRepository.saveBasketballGameDetail(list);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<GameSession> getGameList() {
        List<GameSession> list =  this.gameSessionRepository.getPostList();//这个list就是数据源
        int listNum = 200;
        int returnNum = list.size();
        //如果listNum大于数据源list，直接返回list数据源全部数据
        if(listNum < list.size()) {
            returnNum = listNum;
        }
//        int randomIndex =  (int) (Math.random() * (list.size()-returnNum));
        List<GameSession> resultList= new ArrayList<>();
        for (int i = list.size()-1; i > list.size()-returnNum-1; i--) {
            resultList.add(list.get(i));
        }
        return resultList;
    }

    @Override
    public boolean saveUserOperation(GameBetDTO gameBetDTO) throws Exception {
        GameSession gameSession = this.getDetail(gameBetDTO.getGameId());
        String oddsInformation = gameSession.getOddsInformation();
        JSONArray jsonArray = JSONObject.parseArray(oddsInformation);
        List<BigDecimal> list = jsonArray.toJavaList(BigDecimal.class);
        String gameInfo = gameSession.getGameType()+gameSession.getHome()+"vs"+gameSession.getAway();
        OperationRecord operationRecord = new OperationRecord();
        operationRecord.setPaidScores(gameBetDTO.getPaidScore());
        operationRecord.setUserId(gameBetDTO.getUserId());
        operationRecord.setUserName(gameBetDTO.getUserName());
        if (StringUtils.isNotBlank(gameBetDTO.getComment())){
            operationRecord.setComment(gameBetDTO.getComment());
        }
        if (GameVictoryOrDefeatEnums.VICTORY.name().equals(gameBetDTO.getVictoryOrDefeat())){
            BigDecimal winOdd = list.get(0);
            String oddInfo = GameVictoryOrDefeatEnums.VICTORY.name()+":"+winOdd.toString();
            operationRecord.setOddsInformation(oddInfo);
        }else if (GameVictoryOrDefeatEnums.DRAW.name().equals(gameBetDTO.getVictoryOrDefeat())){
            BigDecimal winOdd = list.get(1);
            String oddInfo = GameVictoryOrDefeatEnums.DRAW.name()+":"+winOdd.toString();
            operationRecord.setOddsInformation(oddInfo);
        }else {
            BigDecimal winOdd = list.get(2);
            String oddInfo = GameVictoryOrDefeatEnums.DEFEAT.name()+":"+winOdd.toString();
            operationRecord.setOddsInformation(oddInfo);
        }
        operationRecord.setOperationStatus(UserOperationEnums.QUIZ.name());
        operationRecord.setGameSession(gameInfo);
        try {
            final UserInfo userInfo = this.userRepository.queryUserInfo(gameBetDTO.getUserId().toString());
            final long l = userInfo.getCurrScores() - gameBetDTO.getPaidScore();
            if (l<0){
                throw new Exception("积分不足");
            }else {
                userInfo.setCurrScores(l);
            }
        this.userRepository.updateUserInfo(userInfo);
        }catch (Exception e){
            return false;
        }
        return this.gameSessionRepository.saveUserOperation(operationRecord);
    }

    @Override
    public boolean updateGameDetail(UpdateGameDetailDTO updateGameDetailDTO) {
        List<String> list = updateGameDetailDTO.getGameId();
        List<GameSession> gameSessions = new ArrayList<>();
        list.forEach(l->{
            GameSession gameSession = new GameSession();
            gameSession.setGameId(Long.valueOf(l));
            String uri1 = "https://api-football-v1.p.rapidapi.com/v3/fixtures?id="+l;
            headers.add("x-rapidapi-host","api-football-v1.p.rapidapi.com");
            headers.add("x-rapidapi-key","77bb1ccd20mshed85a95ffefdbebp187d43jsn4773d71cca23");
            ResponseEntity<String> result2 = HttpRequestA.getResult(headers, uri1);
            FirstLevel<?> result3 = JSONObject.parseObject(result2.getBody(),FirstLevel.class);
            if (null !=result3){
                final Object response = result3.getResponse();
                JSONArray array1 = JSONObject.parseArray(JSONObject.toJSONString(response));
                List<FootballDetail> list1 = array1.toJavaList(FootballDetail.class);
                int home = list1.get(0).getGoals().getHome();
                int away = list1.get(0).getGoals().getAway();
                String result = home +":"+ away;
                gameSession.setGameResult(result);
                gameSessions.add(gameSession);
        }
        });
        this.gameSessionRepository.updateGameDetail(gameSessions);
        return true;
    }

    @Override
    public boolean saveUSGameDetail() {
        String uri = "https://sportspage-feeds.p.rapidapi.com/games?status=final";
//        String uri = "https://sportspage-feeds.p.rapidapi.com/games?status=final&date=2021-10-25";
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-rapidapi-host","sportspage-feeds.p.rapidapi.com");
        headers.add("x-rapidapi-key","0d7c45fae2mshfd5683b00238dcfp1c6861jsn8be58dce0cff");
        ResponseEntity<String> result = HttpRequestA.getResult(headers, uri);
        Result_V2<?> result1 = JSONObject.parseObject(result.getBody(),Result_V2.class);
        if (null!=result1){
            final Object data = result1.getResults();
            JSONArray array = JSONObject.parseArray(JSONObject.toJSONString(data));
            List<US_Sports_Detail> list = array.toJavaList(US_Sports_Detail.class);
            this.gameSessionRepository.save_US_Sports_Detail(list);
            return true;
        }else {
            return false;
        }
    }

}
