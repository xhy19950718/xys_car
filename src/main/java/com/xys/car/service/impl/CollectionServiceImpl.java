package com.xys.car.service.impl;

import com.xys.car.entity.Caryear;
import com.xys.car.entity.Collection;
import com.xys.car.entity.RootEntity;
import com.xys.car.mapper.CollectionMapper;
import com.xys.car.service.ICollectionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zxm
 * @since 2020-12-04
 */
@Service
public class CollectionServiceImpl extends ServiceImpl<CollectionMapper, Collection> implements ICollectionService {

    @Override
    public RootEntity selectCollection(Collection collection) {

        return null;
    }

    @Override
    public RootEntity insertCollection(Collection collection) {
        return null;
    }

    @Override
    public RootEntity updateCollection(Collection collection) {
        return null;
    }

    @Override
    public RootEntity deleteCollection(Collection collection) {
        return null;
    }

}
