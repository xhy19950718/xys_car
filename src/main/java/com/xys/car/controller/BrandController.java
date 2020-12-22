package com.xys.car.controller;


import com.xys.car.entity.Brand;
import com.xys.car.entity.RootEntity;
import com.xys.car.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zxm
 * @since 2020-12-04
 */
@RestController
@RequestMapping("/brand/")
public class BrandController {

    @Autowired
    private IBrandService iBrandService;

    @PostMapping("selectBrand")
    private RootEntity selectBrand(@RequestBody Brand brand){
        return iBrandService.selectBrand(brand);
    }

    @PostMapping("updateBrand")
    private RootEntity updateBrand(@RequestBody Brand brand){
        return iBrandService.updateBrand(brand);
    }

    @PostMapping("deleteBrand")
    private RootEntity deleteBrand(@RequestBody Brand brand){
        return iBrandService.deleteBrand(brand);
    }

    @PostMapping("insertBrand")
    private RootEntity insertBrand(@RequestBody Brand brand){
        return iBrandService.insertBrand(brand);
    }

}

