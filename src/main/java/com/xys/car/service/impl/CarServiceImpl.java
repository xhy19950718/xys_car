package com.xys.car.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xys.car.common.CommonUtil;
import com.xys.car.entity.Brand;
import com.xys.car.entity.Car;
import com.xys.car.entity.CarSelect;
import com.xys.car.entity.RootEntity;
import com.xys.car.entity.select.StatisticsQuery;
import com.xys.car.mapper.CarMapper;
import com.xys.car.service.ICarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zxm
 * @since 2020-12-04
 */
@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements ICarService {


    //标准列表
    @Override
    public RootEntity selectCar(CarSelect car) {
        PageHelper.startPage(car.getPageNum(), car.getPageSize());
        List<Car> listInfo = baseMapper.selectCar(car);
        PageInfo pageInfo = new PageInfo(listInfo);
        return new RootEntity(pageInfo);
    }

    @Override
    public RootEntity updateCar(Car car) {
        if(car==null){
            return new RootEntity(500,"不能为空！",null);
        }
        if(baseMapper.selectById(car.getId())==null){
            return new RootEntity(500,"操作对象不存在",null);
        }
        if(baseMapper.updateById(car)>0){
            return new RootEntity();
        }
        return new RootEntity(500,"未知错误",null);
    }

    @Override
    public RootEntity deleteCar(Car car) {
        //删除
        if(car.getId()==null && car.getId()==""){
            return new RootEntity(500,"id不能为空！",null);
        }
        if(baseMapper.selectById(car.getId())==null){
            return new RootEntity(500,"操作对象不存在",null);
        }
        if(baseMapper.deleteById(car.getId())>0){
            return new RootEntity();
        }
        return new RootEntity(500,"未知错误",null);
    }

    @Override
    public RootEntity insertCar(Car car) {
        car.setId(CommonUtil.getId());
        if(baseMapper.insert(car)>0){
            return new RootEntity();
        }
        return new RootEntity(500,"未知错误",null);
    }

    @Override
    public RootEntity timeOutCar() {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.add(Calendar.MONTH,-3);
        Date time = instance.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(time);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.lt("createtime",format);
        List<Car> list = baseMapper.selectList(queryWrapper);
        return new RootEntity(200,"ok",list);
    }
}
