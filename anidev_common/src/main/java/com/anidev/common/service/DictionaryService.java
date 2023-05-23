package com.anidev.common.service;

import com.anidev.common.po.Dictionary;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * <p>
 * 数据字典 服务类
 * </p>
 *
 * @author sza
 * @since 2023-05-22
 */
public interface DictionaryService extends IService<Dictionary> {
    public Dictionary getOptions();

}
