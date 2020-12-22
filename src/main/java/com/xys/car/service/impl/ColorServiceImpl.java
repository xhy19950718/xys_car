package com.xys.car.service.impl;

import com.xys.car.common.CommonUtil;
import com.xys.car.entity.Caryear;
import com.xys.car.entity.Color;
import com.xys.car.entity.RootEntity;
import com.xys.car.mapper.ColorMapper;
import com.xys.car.service.IColorService;
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
public class ColorServiceImpl extends ServiceImpl<ColorMapper, Color> implements IColorService {

    @Override
    public RootEntity selectColor(Color color) {
        return null;
    }

    @Override
    public RootEntity insertColor(Color color) {
        color.setId(CommonUtil.getId());
        if(baseMapper.insert(color)>0){
            return new RootEntity();
        }
        return new RootEntity(500,"未知添加错误");
    }

    @Override
    public RootEntity updateColor(Color color) {
        if(isNotExits(color)){
            return new RootEntity(500,"操作对象不存在，请刷新后重试");
        }
        if(baseMapper.updateById(color)>0){
            return new RootEntity();
        }
        return new RootEntity(500,"未知修改错误");
    }

    @Override
    public RootEntity deleteColor(Color color) {
        if(isNotExits(color)){
            return new RootEntity(500,"操作对象不存在，请刷新后重试");
        }
        if(baseMapper.deleteById(color.getId())>0){
            return new RootEntity();
        }
        return new RootEntity(500,"未知删除错误");
    }

    //判断操作对象那个是否不存在
    public boolean isNotExits(Color color){
        return baseMapper.selectById(color.getId())!=null;
    }


}
