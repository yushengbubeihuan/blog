package com.banboo.blog.serviceinterface.admin;

import com.banboo.blog.po.User;

public interface UserServiceInterface {
    User checkUser(String username, String password);
}
