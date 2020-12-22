package com.xys.car.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class CarSelect {
    private String name;
    private BigDecimal pricestart;
    private BigDecimal priceend;
    private String type;
    private String brand;
    private String entity;
    private String color;
    private String caryear;
    private Integer pageNum;
    private Integer pageSize;
}
