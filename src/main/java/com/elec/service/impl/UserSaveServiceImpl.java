package com.elec.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.elec.component.MD5Utils;
import com.elec.component.UserFactory;
import com.elec.dal.pojo.User;
import com.elec.dal.pojo.UserInfo;
import com.elec.dto.ModifyWatchListDTO;
import com.elec.dto.UserSaveDTO;
import com.elec.repository.UserRepository;
import com.elec.service.UserSaveService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserSaveServiceImpl implements UserSaveService {
    @Resource
    private UserRepository userRepository;
    @Override
    public String saveUserInfo(UserSaveDTO userSaveDTO){
        //判断是否用用户名存在
        if (this.userRepository.whetherRepeatName(userSaveDTO.getUserName())){
            return "UserName repeat!";
        }else if (this.userRepository.whetherRepeatPhone(userSaveDTO.getPhoneNumber())){
            return "Phone number repeat!";
        }else if (this.userRepository.whetherRepeatEmail(userSaveDTO.getEmail())){
            return "Email repeat!";
        } else {
            //初始化
            User user = UserFactory.create(userSaveDTO);
            //处理密码加密
            String password = MD5Utils.stringToMD5(user.getPassword());
            user.setPassword(password);
            this.userRepository.saveUser(user);
            this.userRepository.saveUserInfo(user);
            return "success";
        }
    }

    @Override
    public Long userLogin(UserSaveDTO userSaveDTO) {
        String password = MD5Utils.stringToMD5(userSaveDTO.getPassword());
        userSaveDTO.setPassword(password);
        return this.userRepository.userLogin(userSaveDTO);
    }

    @Override
    public UserInfo queryUserInfo(String userId) {
        UserInfo userInfo = userRepository.queryUserInfo(userId);
        return userInfo;
    }

    @Override
    public Boolean modifyPassword(String userName,String password) {
        String newPassword = MD5Utils.stringToMD5(password);
        return this.userRepository.modifyPassword(userName,newPassword);
    }

    @Override
    public Boolean modifyWatchList(ModifyWatchListDTO modifyWatchListDTO) {
        //获取用户当前详情
        final UserInfo userInfo = this.queryUserInfo(modifyWatchListDTO.getUserName());
        //更新用户关注列表
        if (StringUtils.isNotBlank(userInfo.getWatchList())){
            JSONArray array = JSONArray.parseArray(userInfo.getPostList());
            List<String> list = array.toJavaList(String.class);
            list.add(modifyWatchListDTO.getWatchUserName());
            userInfo.setWatchList(JSONObject.toJSONString(list));
        }else {
            List<String> list = new ArrayList<>();
            list.add(modifyWatchListDTO.getWatchUserName());
            userInfo.setWatchList(JSONObject.toJSONString(list));
        }
        //入库
        return this.userRepository.updateUserInfo(userInfo);
    }
}
