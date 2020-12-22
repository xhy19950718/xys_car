package com.xys.car.mapper;

import com.xys.car.entity.Car;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xys.car.entity.CarSelect;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zxm
 * @since 2020-12-04
 */
public interface CarMapper extends BaseMapper<Car> {

    List<Car> selectCar(CarSelect car);
}
