package com.tencent.wxcloudrun.bat.springtest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {

    @Autowired


    @Test
    public void testBeanXml(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        context.getBean("user",User.class);

        System.out.println("111");
    }
}
