package com.tencent.wxcloudrun.bat.springtest;

import com.tencent.wxcloudrun.bat.springtest.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Action {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.test();


        /*UserService userService = new UserService("张三");
        userService.test();*/
    }
}
