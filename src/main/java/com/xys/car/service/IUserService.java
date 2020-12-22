package com.xys.car.service;

import com.xys.car.entity.RootEntity;
import com.xys.car.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xys.car.entity.select.UserPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zxm
 * @since 2020-12-04
 */
public interface IUserService extends IService<User> {

    RootEntity selectUser(User user);

    RootEntity selectPageUser(UserPage user);

    RootEntity selectOneUser(User user);

    RootEntity insertUser(User user);

    RootEntity updateUser(User user);

    RootEntity deleteUser(User user);

    RootEntity login(User user);
}
