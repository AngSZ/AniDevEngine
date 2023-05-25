package com.anidev.content.controller;


import com.anidev.content.common.ResultMessage;
import com.anidev.content.po.Articles;
import com.anidev.content.service.ArticlesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResultMessage publish(String title, String content,String value,String phone) {
        log.info("title:{},value:{},content:{},phone:{}",title,value,content,phone);
        Articles articles = new Articles();
        articles.setTitle(title);
        articles.setContent(content);
        articles.setPhone(phone);
        articles.setLabel(value);

        articlesService.publish(articles);

        return new ResultMessage(1, "success");
    }
}
