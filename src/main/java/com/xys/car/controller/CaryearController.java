package com.xys.car.controller;


import com.xys.car.entity.Caryear;
import com.xys.car.entity.RootEntity;
import com.xys.car.service.ICaryearService;
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
@RequestMapping("/caryear")
public class CaryearController {

    @Autowired
    private ICaryearService iCaryearService;

    @PostMapping("selectYears")
    public RootEntity selectYears(@RequestBody Caryear caryear){
        return iCaryearService.selectYears(caryear);
    }
    @PostMapping("insertYears")
    public RootEntity insertYears(@RequestBody Caryear caryear){
        return iCaryearService.insertYears(caryear);
    }
    @PostMapping("updateYears")
    public RootEntity updateYears(@RequestBody Caryear caryear){
        return iCaryearService.updateYears(caryear);
    }
    @PostMapping("deleteYears")
    public RootEntity deleteYears(@RequestBody Caryear caryear){
        return iCaryearService.deleteYears(caryear);
    }
}

