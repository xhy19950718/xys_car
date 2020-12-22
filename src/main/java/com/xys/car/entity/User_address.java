package com.xys.car.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("xys_user_address")
public class User_address implements Serializable {

    private static final long serialVersionUID=1L;

    private String id;

    /**
     * 省
     */
    private Integer province;

    /**
     * 市
     */
    private Integer city;

    /**
     * 县
     */
    private Integer county;

    /**
     * 详细地址
     */
    private String details;

    /**
     * 收货人
     */
    private String name;

    /**
     * 电话
     */
    private String phone;

    private String user_id;


}
