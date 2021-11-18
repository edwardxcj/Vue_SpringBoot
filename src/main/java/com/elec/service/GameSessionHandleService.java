package com.elec.service;

import com.elec.dal.pojo.GameSession;
import com.elec.dto.GameBetDTO;
import com.elec.dto.UpdateGameDetailDTO;

import java.util.List;

public interface GameSessionHandleService {
    /**
     * Get more information about the competition
     * @param gameId
     * @return
     */
    GameSession getDetail(Long gameId);

    /**
     * saveFootball
     * @return
     */
    boolean saveDetail();
    /**
     * saveBasketball
     * @return
     */
    boolean saveBasketballDetail();

    /**
     * get game list
     * @return
     */
    List<GameSession> getGameList();

    /**
     * save the operation of user like bet
     * @param gameBetDTO
     * @return
     */
    boolean saveUserOperation(GameBetDTO gameBetDTO) throws Exception;

    /**
     * update the detail of the game result
     * @param updateGameDetailDTO
     * @return
     */
    boolean updateGameDetail(UpdateGameDetailDTO updateGameDetailDTO);

    /**
     * 保存USsport
     * @return
     */
    boolean saveUSGameDetail();
}
