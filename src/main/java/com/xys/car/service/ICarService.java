package com.xys.car.service;

import com.xys.car.entity.Car;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xys.car.entity.CarSelect;
import com.xys.car.entity.RootEntity;
import com.xys.car.entity.select.StatisticsQuery;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zxm
 * @since 2020-12-04
 */
public interface ICarService extends IService<Car> {

    RootEntity selectCar(CarSelect car);

    RootEntity updateCar(Car car);

    RootEntity deleteCar(Car car);

    RootEntity insertCar(Car car);

    RootEntity timeOutCar();
}
