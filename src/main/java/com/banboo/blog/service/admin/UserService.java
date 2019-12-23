package com.banboo.blog.service.admin;

import com.banboo.blog.dao.admin.UserDao;
import com.banboo.blog.po.User;
import com.banboo.blog.serviceinterface.admin.UserServiceInterface;
import com.banboo.blog.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface{

    @Autowired
    private UserDao userDao;

    @Override
    public User checkUser(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username, MD5Util.code(password));
        return user;
    }
}
