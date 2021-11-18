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
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * user name
     */
    private String userName;

    /**
     * user id random id
     */
    private Long userId;

    /**
     * current total scores
     */
    private Long currScores;

    /**
     * List of user post ids
     */
    private String postList;

    /**
     * watch list 
     */
    private String watchList;

    private Date gmtCreate;

    private Date gmtModified;


}
