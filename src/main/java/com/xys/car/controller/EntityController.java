package com.xys.car.controller;


import com.xys.car.entity.Entity;
import com.xys.car.entity.RootEntity;
import com.xys.car.service.IEntityService;
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
@RequestMapping("/entity")
public class EntityController {

    @Autowired
    private IEntityService iEntityService;

    @PostMapping("selectEntity")
    public RootEntity selectEntity(@RequestBody Entity entity){
        return iEntityService.selectEntity(entity);
    }

    @PostMapping("insertEntity")
    public RootEntity insertEntity(@RequestBody Entity entity){
        return iEntityService.insertEntity(entity);
    }

    @PostMapping("updateEntity")
    public RootEntity updateEntity(@RequestBody Entity entity){
        return iEntityService.updateEntity(entity);
    }

    @PostMapping("deleteEntity")
    public RootEntity deleteEntity(@RequestBody Entity entity){
        return iEntityService.deleteEntity(entity);
    }

}

