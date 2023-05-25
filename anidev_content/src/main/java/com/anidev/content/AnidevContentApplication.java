package com.anidev.content;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AnidevContentApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnidevContentApplication.class, args);
    }

}
