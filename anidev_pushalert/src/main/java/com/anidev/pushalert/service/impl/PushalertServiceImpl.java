package com.anidev.pushalert.service.impl;

import com.anidev.pushalert.clients.ContentClient;
import com.anidev.pushalert.mapper.PushalertMapper;
import com.anidev.pushalert.po.Articles;
import com.anidev.pushalert.po.Pushalert;

import com.anidev.pushalert.service.PushalertService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class PushalertServiceImpl extends ServiceImpl<PushalertMapper, Pushalert> implements PushalertService {
    @Autowired
    private ContentClient contentClient;
    @Override
    public void push(Articles articles) {
        Pushalert pushalert = new Pushalert();
        pushalert.setUserId(articles.getUserId());
        pushalert.setArticleId(articles.getId());
        pushalert.setTitle(articles.getTitle());
        pushalert.setAuthor(articles.getUsername());
        pushalert.setFavorites(articles.getFavorites());
        pushalert.setLabel(articles.getLabel());
        pushalert.setPublished(true);

        LocalDateTime updateTime = contentClient.getUpdateTime(articles.getId());
        pushalert.setUpdateTime(updateTime);
        log.info("pushalert:{}",pushalert);
        this.save(pushalert);
    }
}
