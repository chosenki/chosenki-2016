package com.ki.feature.service;

import com.ki.common.base.BaseService;
import com.ki.feature.api.UserService;
import com.ki.feature.dao.UserDao;
import com.ki.feature.entity.User;
import com.ki.feature.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Wangxiang on 2016/8/28.
 */
@Service("userService")
public class UserServiceImpl extends BaseService<User, UserVo> implements UserService {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUserList() {
        List<User> userList = userDao.findAll();
        System.out.println("getUserList");
        System.out.println(userList);
        return userList;
    }

}
