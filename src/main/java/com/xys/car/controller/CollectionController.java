package com.xys.car.controller;


import com.xys.car.entity.Collection;
import com.xys.car.entity.Color;
import com.xys.car.entity.RootEntity;
import com.xys.car.service.ICollectionService;
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
@RequestMapping("/collection")
public class CollectionController {

    @Autowired
    private ICollectionService iCollectionService;

    @PostMapping("selectCollection")
    public RootEntity selectCollection(@RequestBody Collection collection){
        return iCollectionService.selectCollection(collection);
    }

    @PostMapping("insertCollection")
    public RootEntity insertCollection(@RequestBody Collection collection){
        return iCollectionService.insertCollection(collection);
    }

    @PostMapping("updateCollection")
    public RootEntity updateCollection(@RequestBody Collection collection){
        return iCollectionService.updateCollection(collection);
    }

    @PostMapping("deleteCollection")
    public RootEntity deleteCollection(@RequestBody Collection collection){
        return iCollectionService.deleteCollection(collection);
    }
}

