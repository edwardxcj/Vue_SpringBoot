package com.elec.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.elec.convertor.UserConvertor;
import com.elec.dal.pojo.User;
import com.elec.dal.pojo.UserInfo;
import com.elec.dal.service.IUserInfoService;
import com.elec.dal.service.IUserService;
import com.elec.dto.UserSaveDTO;
import com.elec.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Resource
    private IUserService iUserService;
    @Resource
    private IUserInfoService userInfoService;
    @Override
    public boolean saveUser(User user) {
        this.iUserService.save(user);
        return true;
    }

    @Override
    public boolean saveUserInfo(User user) {
        UserInfo userInfo = UserConvertor.convert2UserInfo(user);
        this.userInfoService.save(userInfo);
        return true;
    }

    @Override
    public boolean whetherRepeatName(String userName) {
        User user = iUserService.getOne(new LambdaQueryWrapper<User>()
                .eq(User::getUserName,userName));
        return null != user;
    }

    @Override
    public boolean whetherRepeatPhone(String phoneNumber) {
        User user = iUserService.getOne(new LambdaQueryWrapper<User>()
                .eq(User::getPhoneNumber,phoneNumber));
        return null != user;
    }

    @Override
    public boolean whetherRepeatEmail(String email) {
        User user = iUserService.getOne(new LambdaQueryWrapper<User>()
                .eq(User::getEmail,email));
        return null != user;
    }

    @Override
    public Long userLogin(UserSaveDTO userSaveDTO) {
        User user = iUserService.getOne(new LambdaQueryWrapper<User>()
                .eq(User::getUserName,userSaveDTO.getUserName()));
        if (null == user){
            return null;
        }else if (!user.getPassword().equals(userSaveDTO.getPassword())){
            return null;
        }else return user.getUserId();
    }

    @Override
    public UserInfo queryUserInfo(String userId) {
        UserInfo userInfo = userInfoService.getOne(new LambdaQueryWrapper<UserInfo>()
                .eq(UserInfo::getUserId,userId));
        return userInfo;
    }
    @Override
    public UserInfo queryUserInfoByName(String userName) {
        UserInfo userInfo = userInfoService.getOne(new LambdaQueryWrapper<UserInfo>()
                .eq(UserInfo::getUserName,userName));
        return userInfo;
    }

    @Override
    public List<UserInfo> getUserInfos() {
        return userInfoService.list(new LambdaQueryWrapper<>());
    }

    @Override
    public boolean modifyPassword(String userName, String password) {
        User user = iUserService.getOne(new LambdaQueryWrapper<User>()
                .eq(User::getUserName,userName));
        user.setPassword(password);
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("user_name",userName);
        return this.iUserService.update(user,updateWrapper);
    }


    @Override
    public Boolean updateUserInfo(UserInfo userInfo) {
        UpdateWrapper<UserInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("user_name",userInfo.getUserName());
        return userInfoService.update(userInfo,updateWrapper);
    }

}