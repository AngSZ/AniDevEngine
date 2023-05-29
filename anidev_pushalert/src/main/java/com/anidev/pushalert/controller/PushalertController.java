package com.anidev.pushalert.controller;


import com.anidev.pushalert.service.PushalertService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("pushalert")
public class PushalertController {

    @Autowired
    private PushalertService pushalertService;
}
