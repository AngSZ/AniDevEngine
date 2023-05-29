package com.anidev.pushalert.clients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;

/**
 * @author suzhengang
 * @create 2023-04-03
 */
@FeignClient("content")//这是微服务的名字
public interface ContentClient {

    @GetMapping("/content/updateTime/{id}")
    LocalDateTime getUpdateTime(@PathVariable Long id);
}
