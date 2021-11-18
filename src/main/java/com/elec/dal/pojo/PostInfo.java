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
public class PostInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Long postId;

    /**
     * user name
     */
    private String userName;

    /**
     * type of the post like basketball
     */
    private String gameType;

    /**
     * title of the post
     */
    private String title;

    /**
     * content of the post
     */
    private String content;

    /**
     * comments of the post
     */
    private String comment;

    /**
     * create time 
     */
    private Date gmtCreate;

    /**
     * modified time
     */
    private Date gmtModified;


}
