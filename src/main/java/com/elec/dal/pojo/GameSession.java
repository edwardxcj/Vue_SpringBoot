package com.elec.dal.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Jinglin
 * @since 2021-10-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GameSession implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * id of games
     */
    private Long gameId;

    /**
     * home team
     */
    private String home;

    /**
     * away team
     */
    private String away;

    /**
     * basketball, football and so on
     */
    private String gameType;

    /**
     * league
     */
    private String league;

    /**
     * the information of odds like win2.1/lose1.9
     */
    private String oddsInformation;

    /**
     * the time of each game
     */
    private Date gameTime;

    /**
     * like xxx 2:0 xxx
     */
    private String gameResult;

    private Date gmtCreate;

    private Date gmtModified;


}
