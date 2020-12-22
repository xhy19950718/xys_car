package com.xys.car.controller;


import com.xys.car.entity.RootEntity;
import com.xys.car.entity.Types;
import com.xys.car.service.ITypesService;
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
@RequestMapping("/types/")
public class TypesController {

    @Autowired
    private ITypesService iTypesService;

    @PostMapping("selectTypes")
    public RootEntity selectTypes(@RequestBody Types types){
        return iTypesService.selectTypes(types);
    }
    @PostMapping("insertTypes")
    public RootEntity insertTypes(@RequestBody Types types){
        return iTypesService.insertTypes(types);
    }
    @PostMapping("updateTypes")
    public RootEntity updateTypes(@RequestBody Types types){
        return iTypesService.updateTypes(types);
    }
    @PostMapping("deleteTypes")
    public RootEntity deleteTypes(@RequestBody Types types){
        return iTypesService.deleteTypes(types);
    }


}

