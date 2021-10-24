package com.atguigu.service;

import com.atguigu.pojo.User;

public interface UserService {

    boolean register(User user) throws Exception;
    User login(User user) throws Exception;
    boolean existsName(String username) throws Exception;
}
