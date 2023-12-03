package com.tencent.wxcloudrun.bat.springtest.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService implements InitializingBean {


    private String userName;

    @Autowired
    private OrderService orderService;

    public void test(){
        System.out.println("userService.test run !");
    }


    public UserService(String userName) {
        this.userName = userName;
    }

    public UserService(String userName,OrderService orderService) {
        this.userName = userName;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.userName = "张三";
    }
}
