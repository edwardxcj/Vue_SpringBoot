package com.elec.dto;

import lombok.Data;

/**
 * 关注用户
 */
@Data
public class ModifyWatchListDTO {
    private String userName;
    private String watchUserName;
}
