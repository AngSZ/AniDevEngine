package com.anidev.content.clients;


import com.anidev.content.po.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author suzhengang
 * @create 2023-04-03
 */
@FeignClient("user")//这是微服务的名字
public interface UserClient {
    @GetMapping("/user/{phone}")
    Integer getUserId(@PathVariable("phone") String phone);
}
