package com.xys.car.service;

import com.xys.car.entity.RootEntity;
import com.xys.car.entity.User_address;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zxm
 * @since 2020-12-04
 */
public interface IUser_addressService extends IService<User_address> {

    RootEntity selectAddress(User_address user_address);

    RootEntity insertAddress(User_address user_address);

    RootEntity updateAddress(User_address user_address);

    RootEntity deleteAddress(User_address user_address);
}
