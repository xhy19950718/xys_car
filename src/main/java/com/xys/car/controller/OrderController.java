package com.xys.car.controller;


import com.xys.car.entity.Order;
import com.xys.car.entity.RootEntity;
import com.xys.car.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zxm
 * @since 2020-12-04
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService iOrderService;

    @PostMapping("selectOrder")
    public RootEntity selectOrder(@RequestBody Order order){
        return iOrderService.selectOrder(order);
    }
    @PostMapping("insertOrder")
    public RootEntity insertOrder(@RequestBody Order order){
        return iOrderService.insertOrder(order);
    }
    @PostMapping("updateOrder")
    public RootEntity updateOrder(@RequestBody Order order){
        return iOrderService.updateOrder(order);
    }
    @PostMapping("deleteOrder")
    public RootEntity deleteOrder(@RequestBody Order order){
        return iOrderService.deleteOrder(order);
    }
}

