package com.xys.car.common;

import java.util.UUID;

public class CommonUtil {

    public static String getId(){
        return UUID.randomUUID().toString();
    }
}
