package com.ki.feature.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Wangxiang on 2016/8/28.
 */
@org.springframework.stereotype.Controller
public class IndexController{

    @RequestMapping("/index1.do")
    public String index(){
        return "index";
    }

}
