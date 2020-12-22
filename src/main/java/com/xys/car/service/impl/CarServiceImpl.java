package com.xys.car.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
        List<Car> listInfo = baseMapper.selectCar(car);
        IPage<Car> pageInfo = new Page(car.getPageNum(),car.getPageSize());
        IPage iPage = baseMapper.selectPage(pageInfo, queryWrapper);

        return null;
    }

    @Override
    public RootEntity updateCar(Car car) {
        if (baseMapper.selectById(car.getId())!=null){
            int i = baseMapper.updateById(car);
            if(i>0){
                return new RootEntity();
            }
        }
        return new RootEntity();
    }

    @Override
    public RootEntity deleteCar(Car car) {//删除
        if(baseMapper.selectById(car.getId())!=null){
            if(baseMapper.deleteById(car.getId())>0){
                return new RootEntity();
            }
        }
        return new RootEntity();
    }

    @Override
    public RootEntity insertCar(Car car) {
        car.setId(UUID.randomUUID().toString());
        if(baseMapper.insert(car)>0){
            return new RootEntity();
        }
        return new RootEntity();
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

    //推荐车型
    public List<Car> vipList(CarSelect car){
        QueryWrapper queryWrapper = new QueryWrapper();
        if(car.getBrand()!=null){
            queryWrapper.eq("brand",car.getBrand());
        }
        if(car.getColor()!=null){
            queryWrapper.eq("color",car.getColor());
        }
        if(car.getEntity()!=null){
            queryWrapper.eq("entity",car.getEntity());
        }
        if(car.getName()!=null){
            queryWrapper.like("name",car.getName());
        }
        if(car.getType()!=null){
            queryWrapper.eq("type",car.getType());
        }
        if(car.getCaryear()!=null){
            queryWrapper.eq("caryear",car.getCaryear());
        }
        if(car.getPriceend()!=null){
            queryWrapper.gt("price",car.getPricestart());
        }
        if(car.getPricestart()!=null){
            queryWrapper.lt("price",car.getPriceend());
        }
        if(car.getPriceend()!=null && car.getPricestart()!=null){
            queryWrapper.between("price",car.getPricestart(),car.getPriceend());
        }
        queryWrapper.eq("del",0);
        queryWrapper.eq("recommend",1);
        List<Car> list = baseMapper.selectList(queryWrapper);
        return list;
    }


}
