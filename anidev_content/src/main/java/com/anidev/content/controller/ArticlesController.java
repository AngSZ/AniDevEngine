package com.anidev.content.controller;


import com.anidev.content.common.ResultMessage;
import com.anidev.content.dto.PostDto;
import com.anidev.content.po.Articles;
import com.anidev.content.service.ArticlesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sza
 */
@Slf4j
@RestController
@RequestMapping("/content")
public class ArticlesController {

    @Autowired
    private ArticlesService articlesService;

    @PostMapping("/publish")
    @Transactional
    public ResultMessage publish(String title, String content,String value,String phone){
        log.info("title:{},value:{},content:{},phone:{}",title,value,content,phone);
        Articles articles = new Articles();
        articles.setTitle(title);
        articles.setContent(content);
        articles.setPhone(phone);
        articles.setLabel(value); //文章主题
        articles.setCreatedDate(LocalDateTime.now());
        articles.setUpdatedDate(LocalDateTime.now());
        articles.setStatus("1");

        articlesService.publish(articles);


        return new ResultMessage(1, "success");
    }

    @GetMapping("/posts")
    public List<PostDto> getPosts(){
        //[{ label:'后端',
        //   title: "微服务搭建内容管理中心",
        //   author: "John",
        //   updateTime: "2023-05-11 09:32:15",
        //   favorites: 5
        // },]

//        log.info("getPosts");
        List<Articles> posts = articlesService.getPosts();
        List<PostDto> collect = posts.stream().map(post -> {
            PostDto postDto = new PostDto();
            postDto.setLabel(post.getLabel());
            postDto.setTitle(post.getTitle());
            postDto.setAuthor(post.getUsername());
            postDto.setUpdateTime(post.getUpdatedDate().toString());
            postDto.setFavorites(post.getFavorites());
            return postDto;
        }).collect(Collectors.toList());
//        log.info("collect:{}",collect);
        return collect;
    }

    @GetMapping("/updateTime/{id}")
    LocalDateTime getUpdateTime(@PathVariable Long id){
        return articlesService.getUpdateTime(id);
    }
}
