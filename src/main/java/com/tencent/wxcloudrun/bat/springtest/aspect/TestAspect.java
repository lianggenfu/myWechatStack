package com.tencent.wxcloudrun.bat.springtest.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.junit.Before;
import org.springframework.stereotype.Component;

@Component
public class TestAspect {

    //@Before("excution(public void com.tencent.wxcloudrun.bat.springiest.service.UserService.test())")
    public void testAspect(Joinpoint joinpoint){
        System.out.println("执行了aop切面");
    }
}
