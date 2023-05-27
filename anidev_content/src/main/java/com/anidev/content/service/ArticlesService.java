package com.anidev.content.service;

import com.anidev.content.po.Articles;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sza
 * @since 2023-05-24
 */
public interface ArticlesService extends IService<Articles> {

    void publish(Articles articles);

    List<Articles> getPosts();
}
