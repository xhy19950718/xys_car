package com.xys.car.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xys.car.common.CommonUtil;
import com.xys.car.entity.Caryear;
import com.xys.car.entity.RootEntity;
import com.xys.car.mapper.CaryearMapper;
import com.xys.car.service.ICaryearService;
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
public class CaryearServiceImpl extends ServiceImpl<CaryearMapper, Caryear> implements ICaryearService {

    @Override
    public RootEntity selectYears(Caryear caryear) {
        QueryWrapper queryWrapper = new QueryWrapper();
        return new RootEntity(baseMapper.selectList(queryWrapper));
    }

    @Override
    public RootEntity insertYears(Caryear caryear) {
        //增加主键id
        caryear.setId(CommonUtil.getId());
        //判断执行结果
        if(baseMapper.insert(caryear)>0){
            return new RootEntity();
        }
        return new RootEntity(500,"未知添加错误");
    }

    @Override
    public RootEntity updateYears(Caryear caryear) {
        if(isNotExits(caryear)){
            return new RootEntity(500,"操作对象不存在，请刷新后重试");
        }
        if(baseMapper.updateById(caryear)>0){
            return new RootEntity();
        }
        return new RootEntity(500,"未知修改错误");
    }

    @Override
    public RootEntity deleteYears(Caryear caryear) {
        if(isNotExits(caryear)){
            return new RootEntity(500,"操作对象不存在，请刷新后重试");
        }
        if(baseMapper.deleteById(caryear.getId())>0){
            return new RootEntity();
        }
        return new RootEntity(500,"未知删除错误");
    }

    //判断操作对象那个是否不存在
    public boolean isNotExits(Caryear caryear){
        return baseMapper.selectById(caryear.getId())!=null;
    }
}
