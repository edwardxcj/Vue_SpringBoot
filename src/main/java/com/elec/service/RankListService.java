package com.elec.service;

import com.elec.dal.pojo.UserInfo;

import java.util.List;

public interface RankListService {
    /**
     * 获取积分排名前50列表
     * @return
     */
    List<UserInfo> getUserInfoList();
}
