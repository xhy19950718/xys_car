package com.xys.car.controller;


import com.xys.car.entity.Color;
import com.xys.car.entity.RootEntity;
import com.xys.car.service.IColorService;
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
@RequestMapping("/color")
public class ColorController {

    @Autowired
    private IColorService iColorService;

    @PostMapping("selectColor")
    public RootEntity selectolor(@RequestBody Color color){
        return iColorService.selectColor(color);
    }

    @PostMapping("insertColor")
    public RootEntity insertColor(@RequestBody Color color){
        return iColorService.insertColor(color);
    }

    @PostMapping("updateColor")
    public RootEntity updateColor(@RequestBody Color color){
        return iColorService.updateColor(color);
    }

    @PostMapping("deleteColor")
    public RootEntity deleteColor(@RequestBody Color color){
        return iColorService.deleteColor(color);
    }
}

