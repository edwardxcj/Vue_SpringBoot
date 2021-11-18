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
public class User implements Serializable {

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
     * phone
     */
    private String phoneNumber;

    /**
     * email information
     */
    private String email;

    /**
     * password coded by MD5
     */
    private String password;

    /**
     * create time
     */
    private Date gmtCreate;

    /**
     * modified time
     */
    private Date gmtModified;


}
