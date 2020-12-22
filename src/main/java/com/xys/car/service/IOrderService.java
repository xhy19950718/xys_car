package com.xys.car.service;

import com.xys.car.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xys.car.entity.RootEntity;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zxm
 * @since 2020-12-04
 */
public interface IOrderService extends IService<Order> {

    RootEntity selectOrder(Order order);

    RootEntity insertOrder(Order order);

    RootEntity updateOrder(Order order);

    RootEntity deleteOrder(Order order);
}
