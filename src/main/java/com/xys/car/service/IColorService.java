package com.xys.car.service;

import com.xys.car.entity.Color;
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
public interface IColorService extends IService<Color> {

    RootEntity selectColor(Color color);

    RootEntity insertColor(Color color);

    RootEntity updateColor(Color color);

    RootEntity deleteColor(Color color);
}
