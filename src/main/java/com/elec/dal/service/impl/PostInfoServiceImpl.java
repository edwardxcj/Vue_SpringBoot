package com.elec.dal.service.impl;

import com.elec.dal.pojo.PostInfo;
import com.elec.dal.mapper.PostInfoMapper;
import com.elec.dal.service.IPostInfoService;
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
public class PostInfoServiceImpl extends ServiceImpl<PostInfoMapper, PostInfo> implements IPostInfoService {

}
