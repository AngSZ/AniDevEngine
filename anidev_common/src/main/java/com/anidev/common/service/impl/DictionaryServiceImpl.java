package com.anidev.common.service.impl;

import com.anidev.common.mapper.DictionaryMapper;
import com.anidev.common.po.Dictionary;
import com.anidev.common.service.DictionaryService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 数据字典 服务实现类
 * </p>
 *
 * @author sza
 */
@Slf4j
@Service
public class DictionaryServiceImpl extends ServiceImpl<DictionaryMapper, Dictionary> implements DictionaryService {
    @Autowired
    private DictionaryMapper dictionaryMapper;
    @Override
    public Dictionary getOptions() {
        LambdaQueryWrapper<Dictionary> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Dictionary::getCode,"000");
        Dictionary dictionary = dictionaryMapper.selectOne(queryWrapper);
        return dictionary;
    }
}
