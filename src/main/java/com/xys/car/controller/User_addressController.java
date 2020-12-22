package com.xys.car.controller;


import com.xys.car.entity.RootEntity;
import com.xys.car.entity.User_address;
import com.xys.car.service.IUser_addressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/user_address/")
public class User_addressController {

    @Autowired
    private IUser_addressService iUser_addressService;

    @PostMapping("selectAddress")
    public RootEntity selectAddress(@RequestBody User_address user_address){
        return iUser_addressService.selectAddress(user_address);
    }
    @PostMapping("insertAddress")
    public RootEntity insertAddress(@RequestBody User_address user_address){
        return iUser_addressService.insertAddress(user_address);
    }
    @PostMapping("updateAddress")
    public RootEntity updateAddress(@RequestBody User_address user_address){
        return iUser_addressService.updateAddress(user_address);
    }
    @PostMapping("deleteAddress")
    public RootEntity deleteAddress(@RequestBody User_address user_address){
        return iUser_addressService.deleteAddress(user_address);
    }
}

