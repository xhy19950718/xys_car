package com.xys.car.controller;


import com.xys.car.entity.Car;
import com.xys.car.entity.CarSelect;
import com.xys.car.entity.RootEntity;
import com.xys.car.entity.select.StatisticsQuery;
import com.xys.car.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zxm
 * @since 2020-12-04
 */
@RestController
@RequestMapping("/car/")
public class CarController {

    @Autowired
    private ICarService iCarService;

    //展示车辆
    @PostMapping("selectCar")
    public RootEntity selectCar(@RequestBody CarSelect car){
        return iCarService.selectCar(car);
    }
    //修改车辆信息
    @PostMapping("updateCar")
    public RootEntity updateCar(@RequestBody Car car){
        return iCarService.updateCar(car);
    }

    //删除车辆
    @PostMapping("deleteCar")
    public RootEntity deleteCar(@RequestBody Car car){
        return iCarService.deleteCar(car);
    }

    //添加车辆
    @PostMapping("insertCar")
    public RootEntity insertCar(@RequestBody Car car){
        return iCarService.insertCar(car);
    }

    //预警车辆
    @PostMapping("timeoutcar")
    public RootEntity timeOutCar(){
        return iCarService.timeOutCar();
    }



}

