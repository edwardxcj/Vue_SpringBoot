package com.elec.service;

import com.elec.dal.pojo.UserInfo;
import com.elec.dto.ModifyWatchListDTO;
import com.elec.dto.UserSaveDTO;

public interface UserSaveService {
    /**
     * 保存用户信息
     * @param userSaveDTO
     * @return
     */
    String saveUserInfo(UserSaveDTO userSaveDTO);

    /**
     * 用户登录
     * @param userSaveDTO
     * @return
     */
    Long userLogin(UserSaveDTO userSaveDTO);

    /**
     * 获取用户详情信息
     * @param userId
     * @return
     */
    UserInfo queryUserInfo(String userId);

    /**
     * 修改用户密码
     * @param userName
     * @return
     */
    Boolean modifyPassword(String userName,String password);

    /**
     * 更新关注信息
     * @param modifyWatchListDTO
     * @return
     */
    Boolean modifyWatchList(ModifyWatchListDTO modifyWatchListDTO);
}
