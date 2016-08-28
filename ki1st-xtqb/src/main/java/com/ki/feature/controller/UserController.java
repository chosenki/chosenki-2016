package com.ki.feature.controller;

import com.ki.feature.api.UserService;
import com.ki.feature.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Wangxiang on 2016/8/28.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list.do")
    @ResponseBody
    public List<User> index(){
        return userService.getUserList();
    }

}
