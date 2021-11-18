package com.elec.component;

import com.elec.dal.pojo.User;
import com.elec.dto.UserSaveDTO;

import java.util.Date;

public class UserFactory {
    public static User create(UserSaveDTO userSaveDTO){
        User user = new User();
        user.setUserId(GenerateId.getGeneratID());
        user.setUserName(userSaveDTO.getUserName());
        user.setEmail(userSaveDTO.getEmail());
        user.setPassword(userSaveDTO.getPassword());
        user.setPhoneNumber(userSaveDTO.getPhoneNumber());
        user.setGmtCreate(new Date());
        user.setGmtModified(new Date());
        return user;
    }
}
