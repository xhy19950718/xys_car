package com.xys.car.service;

import com.xys.car.entity.Collection;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xys.car.entity.Color;
import com.xys.car.entity.RootEntity;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zxm
 * @since 2020-12-04
 */
public interface ICollectionService extends IService<Collection> {

    RootEntity selectCollection(Collection collection);

    RootEntity insertCollection(Collection collection);

    RootEntity updateCollection(Collection collection);

    RootEntity deleteCollection(Collection collection);
}
