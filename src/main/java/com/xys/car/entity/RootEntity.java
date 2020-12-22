package com.xys.car.entity;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Data
public class RootEntity {
    private Integer code;
    private String msg;
    private Object data;

    public RootEntity() {
        this.code = 200;
        this.msg = "ok";
        this.data = null;
    }

    public RootEntity(Object data) {
        this.code = 200;
        this.msg = "ok";
        this.data = data;
    }

    public RootEntity(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data=null;
    }

    public RootEntity(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
