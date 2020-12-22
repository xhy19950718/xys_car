package com.xys.car.service;

import com.xys.car.entity.Brand;
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
public interface IBrandService extends IService<Brand> {

    RootEntity selectBrand(Brand brand);

    RootEntity updateBrand(Brand brand);

    RootEntity deleteBrand(Brand brand);

    RootEntity insertBrand(Brand brand);
}
