package com.xys.car.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xys.car.common.CommonUtil;
import com.xys.car.entity.Caryear;
import com.xys.car.entity.Entity;
import com.xys.car.entity.RootEntity;
import com.xys.car.mapper.EntityMapper;
import com.xys.car.service.IEntityService;
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
public class EntityServiceImpl extends ServiceImpl<EntityMapper, Entity> implements IEntityService {

    @Override
    public RootEntity selectEntity(Entity entity) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if(entity.getName()!=null){
            queryWrapper.like("name",entity.getName());
        }
        if(entity.getBrand()!=null){
            queryWrapper.eq("brand",entity.getBrand());
        }
        List<Entity> list = baseMapper.selectList(queryWrapper);

        return new RootEntity(list);
    }

    @Override
    public RootEntity insertEntity(Entity entity) {
        //增加主键id
        entity.setId(CommonUtil.getId());
        //判断执行结果
        if(baseMapper.insert(entity)>0){
            return new RootEntity();
        }
        return new RootEntity(500,"未知添加错误");
    }

    @Override
    public RootEntity updateEntity(Entity entity) {
        if(isNotExits(entity)){
            return new RootEntity(500,"操作对象不存在，请刷新后重试");
        }
        if(baseMapper.updateById(entity)>0){
            return new RootEntity();
        }
        return new RootEntity(500,"未知修改错误");
    }

    @Override
    public RootEntity deleteEntity(Entity entity) {
        if(isNotExits(entity)){
            return new RootEntity(500,"操作对象不存在，请刷新后重试");
        }
        if(baseMapper.deleteById(entity.getId())>0){
            return new RootEntity();
        }
        return new RootEntity(500,"未知删除错误");
    }

    //判断操作对象那个是否不存在
    public boolean isNotExits(Entity entity){
        return baseMapper.selectById(entity.getId())!=null;
    }
}
