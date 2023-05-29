package com.anidev.pushalert;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * @author suzhengang
 * @create 2023-05-28
 */
@EnableFeignClients
@Slf4j
@SpringBootApplication
public class AnidevPushalertApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnidevPushalertApplication.class,args);
    }
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
