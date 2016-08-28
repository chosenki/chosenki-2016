package com.ki.feature.controller;

import com.ki.feature.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Wangxiang on 2016/8/28.
 */
@org.springframework.stereotype.Controller
public class IndexController{

    @Autowired
    private UserService userService;

    @RequestMapping("/index1.do")
    public String index(){
        userService.getUserList();
        return "index";
    }

}
