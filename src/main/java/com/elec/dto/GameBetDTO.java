package com.elec.dto;

import lombok.Data;

@Data
public class GameBetDTO {
    private Long paidScore;
    private String userName;
    private Long userId;
    private Long gameId;
    private String comment;
    /**
     * user choose
     * win or lose for the home team
     * VICTORY/DRAW/DEFEAT
     */
    private String victoryOrDefeat;
}
