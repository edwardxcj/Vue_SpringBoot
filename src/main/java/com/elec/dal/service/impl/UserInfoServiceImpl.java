package com.elec.dal.service.impl;

import com.elec.dal.pojo.UserInfo;
import com.elec.dal.mapper.UserInfoMapper;
import com.elec.dal.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jinglin
 * @since 2021-10-08
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
