package com.anidev.user.controller;


import com.anidev.user.common.ResultMessage;
import com.anidev.user.po.User;
import com.anidev.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sza
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public ResultMessage login(String phone,String password) {
        User user = userService.userLogin(phone, password);
        return new ResultMessage(1,"Token",user);
    }
    @PostMapping("/regist")
    public ResultMessage regist( User user){
        log.info("user:{}",user);
        ResultMessage resultMessage = userService.userRegist(user);
        return resultMessage;
    }
}
