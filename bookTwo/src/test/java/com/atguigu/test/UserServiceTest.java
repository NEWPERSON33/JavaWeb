package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.impl.UserServiceimpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    @Test
    public void register() throws Exception {
        UserServiceimpl userServiceimpl = new UserServiceimpl();
        boolean baiRuo = userServiceimpl.register(new User("BaiRuo", "123", "591@gmail.com"));
        System.out.println(baiRuo);
    }

    @Test
    public void login() throws Exception {
        UserServiceimpl userServiceimpl = new UserServiceimpl();
        System.out.println(userServiceimpl.login(new User("BaiRuo", "123", "591@gmail.com")));
    }

    @Test
    public void existsName() throws Exception {
        UserServiceimpl userServiceimpl = new UserServiceimpl();
        System.out.println(userServiceimpl.existsName("BaiRuo"));
    }
}