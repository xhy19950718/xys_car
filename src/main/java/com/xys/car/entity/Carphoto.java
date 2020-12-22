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
@TableName("xys_carphoto")
public class Carphoto implements Serializable {

    private static final long serialVersionUID=1L;

    private String carid;

    /**
     * 图片
     */
    private String photo;

    /**
     * 主图
     */
    private Integer index;


}
