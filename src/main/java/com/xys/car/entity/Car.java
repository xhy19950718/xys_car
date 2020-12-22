package com.xys.car.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDate;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import net.bytebuddy.implementation.bind.annotation.Super;

/**
 * <p>
 * 
 * </p>
 *
 * @author zxm
 * @since 2020-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("xys_car")
public class Car extends RootEntity implements Serializable{

    private static final long serialVersionUID=1L;

    private String id;

    /**
     * 名字
     */
    private String name;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 年款
     */
    private String caryear;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 颜色
     */
    private String color;

    /**
     * 型号
     */
    private String entity;

    /**
     * 类型
     */
    private String type;

    /**
     * 行驶里程
     */
    private Double uselong;

    /**
     * 有无事故
     */
    private Integer accident;

    /**
     * 使用几年
     */
    private Integer useyear;

    /**
     * 是否喷漆
     */
    private Integer paint;

    /**
     * 入库时间
     */
    private LocalDate createtime;

    /**
     * 热度
     */
    private Integer hot;

    /**
     * 推荐
     */
    private Integer recommend;

    /**
     * 删除
     */
    private Integer del;


}
