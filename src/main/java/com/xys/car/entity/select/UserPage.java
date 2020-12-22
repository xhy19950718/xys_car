package com.xys.car.entity.select;

import com.xys.car.entity.User;
import lombok.Data;

@Data
public class UserPage extends User {

    private Integer pageNum;

    private Integer pageSize;
}
