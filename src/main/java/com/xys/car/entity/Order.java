package com.xys.car.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@TableName("xys_order")
public class Order implements Serializable {

    private static final long serialVersionUID=1L;

    private String id;

    /**
     * 订单号
     */
    private String code;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 车辆id
     */
    private String car;

    /**
     * 用户
     */
    private String user_id;

    /**
     * 创建时间
     */
    private LocalDateTime createtime;

    /**
     * 结束时间
     */
    private LocalDateTime endtime;

    /**
     * 订单状态
     */
    private Integer status;

    /**
     * 地址id
     */
    private String address;


}
