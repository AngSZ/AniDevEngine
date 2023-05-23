package com.anidev.common.controller;


import com.anidev.common.common.ResultMessage;
import com.anidev.common.po.Dictionary;
import com.anidev.common.service.DictionaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 数据字典 前端控制器
 * </p>
 *
 * @author sza
 */
@Slf4j
@RestController
@RequestMapping("/common")
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;
    @GetMapping("/options")
    public String getOptions(){
        Dictionary options = dictionaryService.getOptions();
        return options.getItems();
    }
}
