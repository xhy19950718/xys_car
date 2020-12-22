package com.xys.car.controller;

import com.xys.car.entity.RootEntity;
import com.xys.car.entity.User;
import com.xys.car.service.IStatisticsService;
import com.xys.car.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics/")
public class StatisticsController {

    @Autowired
    private IStatisticsService iStatisticsService;
    @Autowired
    private IUserService iUserService;

    //判断用户名是否存在
    @PostMapping("isExistUsername")
    public RootEntity isExistUsername(@RequestBody String username){
        return iStatisticsService.isExistUsername(username);
    }
    @PostMapping("/login")
    public RootEntity login(@RequestBody User user){
        return iUserService.login(user);
    }






}
