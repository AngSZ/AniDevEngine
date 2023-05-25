package com.anidev.content.service.impl;

import com.anidev.content.clients.UserClient;
import com.anidev.content.mapper.ArticlesMapper;
import com.anidev.content.po.Articles;
import com.anidev.content.service.ArticlesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
    public void publish(Articles articles) {
        log.info("articles:{}",articles);
        //拿到user_id
        Integer userId = userClient.getUserId(articles.getPhone());
        articles.setUserId(userId);
        log.info("userId: ",userId);
        this.save(articles);
    }
}
