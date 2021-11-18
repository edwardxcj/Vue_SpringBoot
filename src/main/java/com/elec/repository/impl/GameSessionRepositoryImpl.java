package com.elec.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.elec.component.GenerateId;
import com.elec.convertor.UserConvertor;
import com.elec.dal.pojo.GameSession;
import com.elec.dal.pojo.OperationRecord;
import com.elec.dal.service.IGameSessionService;
import com.elec.dal.service.IOperationRecordService;
import com.elec.dto.valueObj.US_Sports_Detail;
import com.elec.dto.valueObj.basketball.BasketDetail;
import com.elec.dto.valueObj.football.FootballDetail;
import com.elec.repository.GameSessionRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GameSessionRepositoryImpl implements GameSessionRepository {
    @Resource
    private IGameSessionService iGameSessionService;
    @Resource
    private IOperationRecordService iOperationRecordService;
    @Override
    public GameSession getDetailById(Long gameId) {
        GameSession gameSession = this.iGameSessionService.getOne(new LambdaQueryWrapper<GameSession>()
                .eq(GameSession::getGameId,gameId));
        return gameSession;
    }

    @Override
    public boolean saveFootballGameDetail(List<FootballDetail> details) {
        List<GameSession> gameSessions = new ArrayList<>();
        details.forEach(detail->{
            GameSession gameSession = UserConvertor.convert2GameSession(detail);
            gameSessions.add(gameSession);
        });
        return this.iGameSessionService.saveBatch(gameSessions);
    }

    @Override
    public boolean saveBasketballGameDetail(List<BasketDetail> details) {
        List<GameSession> gameSessions = new ArrayList<>();
        details.forEach(detail->{
            GameSession gameSession = UserConvertor.convert2BasketballGameSession(detail);
            gameSessions.add(gameSession);
        });
        return this.iGameSessionService.saveBatch(gameSessions);
    }

    @Override
    public boolean updateFootballGameDetail(List<GameSession> gameSessions) {
        return false;
    }

    @Override
    public List<GameSession> getPostList() {
        List<GameSession> gameSessions = iGameSessionService.list(new LambdaQueryWrapper<>());
        return gameSessions;
    }

    @Override
    public boolean saveUserOperation(OperationRecord operationRecord) {
        operationRecord.setOperationId(GenerateId.getGeneratID());
        return this.iOperationRecordService.save(operationRecord);
    }

    @Override
    public boolean updateGameDetail(List<GameSession> gameSession) {
        gameSession.forEach(g->{
            GameSession gameSession1 = iGameSessionService.getOne(new LambdaQueryWrapper<GameSession>()
                    .eq(GameSession::getGameId,g.getGameId()));
            gameSession1.setGameResult(g.getGameResult());
            UpdateWrapper<GameSession> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("game_id",gameSession1.getGameId());
            this.iGameSessionService.update(gameSession1, updateWrapper);
        });
        return true;
    }
    @Override
    public boolean save_US_Sports_Detail(List<US_Sports_Detail> details) {
        List<GameSession> gameSessions = new ArrayList<>();
        details.forEach(detail->{
            GameSession gameSession = UserConvertor.convert2USGameSession(detail);
            gameSessions.add(gameSession);
        });
        return this.iGameSessionService.saveBatch(gameSessions);
    }

}
