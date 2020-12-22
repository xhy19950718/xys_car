package com.xys.car.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xys.car.entity.RootEntity;
import com.xys.car.mapper.UserMapper;
import com.xys.car.service.IStatisticsService;
import com.xys.car.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IStatisticsServiceImpl implements IStatisticsService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public RootEntity isExistUsername(String username) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username",username);
        Integer size = userMapper.selectCount(queryWrapper);
        if(size>0){
            return new RootEntity();
        }
        return new RootEntity(500,"用户名已被注册");
    }
}
