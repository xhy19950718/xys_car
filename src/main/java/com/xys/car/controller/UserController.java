package com.xys.car.controller;


import com.xys.car.entity.RootEntity;
import com.xys.car.entity.User;
import com.xys.car.service.IUserService;
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
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private IUserService iUserService;

    //按条件查询所有用户
    @PostMapping("selectUser")
    public RootEntity selectUser(@RequestBody User user){
        return iUserService.selectUser(user);
    }
    //新增用户
    @PostMapping("insertUser")
    public RootEntity insertUser(@RequestBody User user){
        return iUserService.insertUser(user);
    }
    //修改用户
    @PostMapping("updateUser")
    public RootEntity updateUser(@RequestBody User user){
        return iUserService.updateUser(user);
    }
    //删除用户
    @PostMapping("deleteUser")
    public RootEntity deleteUser(@RequestBody User user){
        return iUserService.deleteUser(user);
    }


}

