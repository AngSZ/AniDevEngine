package com.anidev.pushalert.service;


import com.anidev.pushalert.po.Articles;
import com.anidev.pushalert.po.Pushalert;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sza
 * @since 2023-05-29
 */
public interface PushalertService extends IService<Pushalert> {

    void push(Articles articles);
}
