package com.xys.car.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.xys.car.entity.RootEntity;
import com.xys.car.entity.User;
import com.xys.car.entity.User_address;
import com.xys.car.entity.select.UserPage;
import com.xys.car.mapper.UserMapper;
import com.xys.car.service.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public RootEntity selectUser(User user) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("nickname",user.getNickname());
        queryWrapper.like("username",user.getUsername());
        return new RootEntity(baseMapper.selectList(queryWrapper));
    }

    @Override
    public RootEntity selectPageUser(UserPage user) {
        IPage page = new Page(user.getPageNum(),user.getPageSize());
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("nickname",user.getNickname());
        queryWrapper.like("username",user.getUsername());
        return new RootEntity(baseMapper.selectPage(page,queryWrapper));
    }

    @Override
    public RootEntity selectOneUser(User user) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("id",user.getId());
        return new RootEntity(baseMapper.selectOne(queryWrapper));
    }

    @Override
    public RootEntity insertUser(User user) {
        if ("".equals(user.getImg())){
            if(0==user.getGender()){
                user.setImg("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2252489002,1762979692&fm=26&gp=0.jpg");
            }
            user.setImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1607714579152&di=210b5dd23e05373b062d4438ed679fbe&imgtype=0&src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fitem%2F201509%2F03%2F20150903234841_vtFP5.thumb.400_0.jpeg");
        }
        if(baseMapper.insert(user)>0){
            return new RootEntity();
        }
        return new RootEntity(500,"未知添加错误");
    }

    @Override
    public RootEntity updateUser(User user) {
        if(isNotExits(user)){
            return new RootEntity(500,"操作对象不存在，请刷新后重试");
        }
        if(baseMapper.updateById(user)>0){
            return new RootEntity();
        }
        return new RootEntity(500,"未知修改错误");
    }

    @Override
    public RootEntity deleteUser(User user) {
        if(isNotExits(user)){
            return new RootEntity(500,"操作对象不存在，请刷新后重试");
        }
        if(baseMapper.deleteById(user.getId())>0){
            return new RootEntity();
        }
        return new RootEntity(500,"未知删除错误");
    }

    @Override
    public RootEntity login(User user) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username",user.getUsername());
        User userInfo = baseMapper.selectOne(queryWrapper);
        if(userInfo==null){
            return new RootEntity(500,"该账号为注册！");
        }
        if(userInfo.getPassword().equals(user.getPassword())){
            return new RootEntity(userInfo);
        }else{
            return new RootEntity(500,"密码错误！");
        }

    }

    //判断操作对象那个是否不存在
    public boolean isNotExits(User user){
        return baseMapper.selectById(user.getId())!=null;
    }

}
