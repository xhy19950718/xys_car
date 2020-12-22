package com.xys.car.service.impl;

import com.xys.car.entity.Color;
import com.xys.car.entity.RootEntity;
import com.xys.car.entity.Types;
import com.xys.car.mapper.TypesMapper;
import com.xys.car.service.ITypesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zxm
 * @since 2020-12-04
 */
@Service
public class TypesServiceImpl extends ServiceImpl<TypesMapper, Types> implements ITypesService {

    @Override
    public RootEntity selectTypes(Types types) {
        return null;
    }

    @Override
    public RootEntity insertTypes(Types types) {
        return null;
    }

    @Override
    public RootEntity updateTypes(Types types) {
        if(isNotExits(types)){
            return new RootEntity(500,"操作对象不存在，请刷新后重试");
        }
        if(baseMapper.updateById(types)>0){
            return new RootEntity();
        }
        return new RootEntity(500,"未知修改错误");
    }

    @Override
    public RootEntity deleteTypes(Types types) {
        if(isNotExits(types)){
            return new RootEntity(500,"操作对象不存在，请刷新后重试");
        }
        if(baseMapper.deleteById(types.getId())>0){
            return new RootEntity();
        }
        return new RootEntity(500,"未知删除错误");
    }

    //判断操作对象那个是否不存在
    public boolean isNotExits(Types types){
        return baseMapper.selectById(types.getId())!=null;
    }
}
