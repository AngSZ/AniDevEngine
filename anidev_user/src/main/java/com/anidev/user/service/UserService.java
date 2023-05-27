package com.anidev.user.service;

import com.anidev.user.common.ResultMessage;
import com.anidev.user.po.User;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sza
 * @since 2023-05-15
 */
public interface UserService extends IService<User> {
        public User userLogin(String phone,String password);
        public ResultMessage userRegist(User user);

        User getUserId(String phone);

        User getUsername(String phone);
}
