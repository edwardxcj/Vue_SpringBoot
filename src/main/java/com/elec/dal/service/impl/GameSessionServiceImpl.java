package com.elec.dal.service.impl;

import com.elec.dal.pojo.GameSession;
import com.elec.dal.mapper.GameSessionMapper;
import com.elec.dal.service.IGameSessionService;
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
public class GameSessionServiceImpl extends ServiceImpl<GameSessionMapper, GameSession> implements IGameSessionService {

}
