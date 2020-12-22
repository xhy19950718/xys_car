package com.xys.car.service;

import com.xys.car.entity.Entity;
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
public interface IEntityService extends IService<Entity> {

    RootEntity selectEntity(Entity entity);

    RootEntity insertEntity(Entity entity);

    RootEntity updateEntity(Entity entity);

    RootEntity deleteEntity(Entity entity);
}
