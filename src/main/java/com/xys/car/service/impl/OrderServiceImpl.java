package com.xys.car.service.impl;

import com.xys.car.entity.Order;
import com.xys.car.entity.RootEntity;
import com.xys.car.mapper.OrderMapper;
import com.xys.car.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zxm
 * @since 2020-12-04
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Override
    public RootEntity selectOrder(Order order) {
        return null;
    }

    @Override
    public RootEntity insertOrder(Order order) {
        return null;
    }

    @Override
    public RootEntity updateOrder(Order order) {
        return null;
    }

    @Override
    public RootEntity deleteOrder(Order order) {
        return null;
    }
}
