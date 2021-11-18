package com.elec.repository;

import com.elec.dal.pojo.GameSession;
import com.elec.dal.pojo.OperationRecord;
import com.elec.dto.valueObj.US_Sports_Detail;
import com.elec.dto.valueObj.basketball.BasketDetail;
import com.elec.dto.valueObj.football.FootballDetail;

import java.util.List;

public interface GameSessionRepository {
    /**
     * Get match details by ID
     * @param gameId
     * @return
     */
    GameSession getDetailById (Long gameId);

    /**
     * Save game info
     * @param details
     * @return
     */
    boolean saveFootballGameDetail(List<FootballDetail> details);
    boolean saveBasketballGameDetail(List<BasketDetail> details);

    /**
     * updateResult
     * @param gameSessions
     * @return
     */
    boolean updateFootballGameDetail(List<GameSession> gameSessions);

    /**
     * getGameList
     * @return
     */
    List<GameSession> getPostList();

    /**
     * save the bet record
     * @param operationRecord
     * @return
     */
    boolean saveUserOperation (OperationRecord operationRecord);

    /**
     * update
     * @param gameSession
     * @return
     */
    boolean updateGameDetail(List<GameSession> gameSession);

    boolean save_US_Sports_Detail(List<US_Sports_Detail> details);
}
