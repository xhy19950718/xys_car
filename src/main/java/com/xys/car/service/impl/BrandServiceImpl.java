package com.xys.car.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xys.car.common.CommonUtil;
import com.xys.car.entity.Brand;
import com.xys.car.entity.Caryear;
import com.xys.car.entity.RootEntity;
import com.xys.car.mapper.BrandMapper;
import com.xys.car.service.IBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zxm
 * @since 2020-12-04
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {

    @Override
    public RootEntity selectBrand(Brand brand) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if(brand.getName()!=null){
            queryWrapper.like("name",brand.getName());
        }
        baseMapper.selectList(queryWrapper);
        return null;
    }

    @Override
    public RootEntity updateBrand(Brand brand) {
        if(isNotExits(brand)){
            return new RootEntity(500,"操作对象不存在，请刷新后重试");
        }
        if(baseMapper.updateById(brand)>0){
            return new RootEntity();
        }
        return new RootEntity(500,"未知修改错误");

    }

    @Override
    public RootEntity deleteBrand(Brand brand) {
        if(isNotExits(brand)){
            return new RootEntity(500,"操作对象不存在，请刷新后重试");
        }
        if(baseMapper.deleteById(brand.getId())>0){
            return new RootEntity();
        }
        return new RootEntity(500,"未知删除错误");


    }

    @Override
    public RootEntity insertBrand(Brand brand) {
        //添加主键id
        brand.setId(CommonUtil.getId());
        if(baseMapper.insert(brand)>0){
            return new RootEntity();
        }
        return new RootEntity(500,"未知添加错误");
    }

    //判断操作对象那个是否不存在
    public boolean isNotExits(Brand brand){
        return baseMapper.selectById(brand.getId())!=null;
    }
}
