package com.anidev.user.service.impl;
import com.anidev.user.common.ResultMessage;
import com.anidev.user.mapper.UserMapper;
import com.anidev.user.po.User;
import com.anidev.user.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.security.MessageDigest;
import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sza
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User userLogin(String phone, String password) {
        log.info("phone:{},password:{}", phone, password);
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getPhone,phone);
        User user = userMapper.selectOne(queryWrapper);
        if(user == null){
            throw new RuntimeException("用户不存在");
        }
        if(!user.getPassword().equals(password)){
            throw new RuntimeException("密码错误");
        }
        if (user.getStatus() == 1){
            throw new RuntimeException("用户已被禁用");
        }
        return user;

    }

    @Override
    public ResultMessage userRegist(User user) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getPhone,user.getPhone());
        User one = userMapper.selectOne(queryWrapper);
        if(one != null){
            return new ResultMessage(0,"手机号已被注册");
        }
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getEmail,user.getEmail());
        one = userMapper.selectOne(wrapper);
        if (one != null){
            return new ResultMessage(0,"邮箱已被注册");
        }
        user.setRegistrationDate(LocalDateTime.now());
        user.setStatus(0);
        user.setRole(3);
        //md5加密
        String md5DigestAsHex = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(md5DigestAsHex);
        userMapper.insert(user);
        return new ResultMessage(1,"注册成功");
    }
}
