package com.xys.car.service;

import com.xys.car.entity.RootEntity;
import com.xys.car.entity.Types;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zxm
 * @since 2020-12-04
 */
public interface ITypesService extends IService<Types> {

    RootEntity selectTypes(Types types);

    RootEntity insertTypes(Types types);

    RootEntity updateTypes(Types types);

    RootEntity deleteTypes(Types types);
}
