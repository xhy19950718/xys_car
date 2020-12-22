package com.xys.car.service;

import com.xys.car.entity.Caryear;
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
public interface ICaryearService extends IService<Caryear> {

    RootEntity selectYears(Caryear caryear);

    RootEntity insertYears(Caryear caryear);

    RootEntity updateYears(Caryear caryear);

    RootEntity deleteYears(Caryear caryear);
}
