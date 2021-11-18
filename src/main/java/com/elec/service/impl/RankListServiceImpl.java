package com.elec.service.impl;

import com.elec.component.ScoreSort;
import com.elec.dal.pojo.UserInfo;
import com.elec.repository.UserRepository;
import com.elec.service.RankListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class RankListServiceImpl implements RankListService {
    @Resource
    private UserRepository userRepository;
    @Override
    public List<UserInfo> getUserInfoList() {
        //获取所有用户信息
        List<UserInfo> infos = this.userRepository.getUserInfos();
        //积分排序
        ScoreSort.sort(infos);
        //截取50条数据
        if (infos.size()<20){
            return infos;
        }else {
            List<UserInfo> newList = infos.subList(0, 20);
            return newList;
        }
    }
}
