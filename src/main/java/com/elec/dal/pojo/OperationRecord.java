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
public class OperationRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * user name
     */
    private String userName;

    /**
     * user id
     */
    private Long userId;

    /**
     * random id
     */
    private Long operationId;

    /**
     * paid scores
     */
    private Long paidScores;

    /**
     * received scores
     */
    private Long receivedScores;

    /**
     * the information of game
     */
    private String gameSession;

    /**
     * information of odds this game
     */
    private String oddsInformation;

    /**
     * like have-bet or not-bet
     */
    private String operationStatus;

    /**
     * comment on this game
     */
    private String comment;

    private Date gmtCreate;

    private Date gmtModified;


}
