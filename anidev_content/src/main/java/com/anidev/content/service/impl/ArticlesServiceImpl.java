package com.anidev.content.service.impl;

import com.anidev.content.clients.UserClient;
import com.anidev.content.mapper.ArticlesMapper;
import com.anidev.content.po.Articles;
import com.anidev.content.service.ArticlesService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sza
 */
@Slf4j
@Service
public class ArticlesServiceImpl extends ServiceImpl<ArticlesMapper, Articles> implements ArticlesService {
    @Autowired
    private UserClient userClient;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void publish(Articles articles){
//        log.info("articles:{}",articles);
        //拿到user_id
        Long userId = userClient.getUserId(articles.getPhone());
        String username = userClient.getUsername(articles.getPhone());
        articles.setUserId(userId);
        articles.setUsername(username);
//        log.info("userId: ",userId);
        this.save(articles);

        articles.setUpdatedDate(null);
        articles.setCreatedDate(null);
        rabbitTemplate.convertAndSend("push.exchange","articles",articles);
    }

    @Override
    public List<Articles> getPosts() {
        LambdaQueryWrapper<Articles> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Articles::getUpdatedDate);
        List<Articles> list = this.list(queryWrapper);
//        Collections.reverse(list);
        return list;
    }

    @Override
    public LocalDateTime getUpdateTime(Long id) {
        LambdaQueryWrapper<Articles> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Articles::getId,id);
        Articles one = this.getOne(queryWrapper);
        return one.getUpdatedDate();
    }


}
