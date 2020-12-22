package com.xys.car.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xys.car.common.CommonUtil;
import com.xys.car.entity.Color;
import com.xys.car.entity.RootEntity;
import com.xys.car.entity.User_address;
import com.xys.car.mapper.User_addressMapper;
import com.xys.car.service.IUser_addressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zxm
 * @since 2020-12-04
 */
@Service
public class User_addressServiceImpl extends ServiceImpl<User_addressMapper, User_address> implements IUser_addressService {

    @Override
    public RootEntity selectAddress(User_address user_address) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if(user_address.getUser_id()!=null){
            queryWrapper.eq("user_id",user_address.getUser_id());
        }
        List<User_address> list = baseMapper.selectList(queryWrapper);
        return new RootEntity(list);
    }

    @Override
    public RootEntity insertAddress(User_address user_address) {
        user_address.setId(CommonUtil.getId());
        if(baseMapper.insert(user_address)>0){
            return new RootEntity();
        }
        return new RootEntity(500,"未知添加错误");
    }

    @Override
    public RootEntity updateAddress(User_address user_address) {
        if(isNotExits(user_address)){
            return new RootEntity(500,"操作对象不存在，请刷新后重试");
        }
        if(baseMapper.updateById(user_address)>0){
            return new RootEntity();
        }
        return new RootEntity(500,"未知修改错误");
    }

    @Override
    public RootEntity deleteAddress(User_address user_address) {
        if(isNotExits(user_address)){
            return new RootEntity(500,"操作对象不存在，请刷新后重试");
        }
        if(baseMapper.deleteById(user_address.getId())>0){
            return new RootEntity();
        }
        return new RootEntity(500,"未知删除错误");
    }


    //判断操作对象那个是否不存在
    public boolean isNotExits(User_address user_address){
        return baseMapper.selectById(user_address.getId())!=null;
    }
}
