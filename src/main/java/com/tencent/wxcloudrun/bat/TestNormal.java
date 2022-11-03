package com.tencent.wxcloudrun.bat;

import org.junit.Test;

public class TestNormal {

    @Test
    public void test1(){
        int a = 10;
        int result = calculate(a);
        System.out.println(result);
    }

    private int calculate(int a) {
        try{
            a = a / 0;
            return a;
        }catch (Exception e){
            e.printStackTrace();
            return a;
        }finally {
            System.out.println("sss");
            //return a;
        }
    }

    @Test
    public void test2() throws InterruptedException {
        Object a = new Object();
        a.wait();

        StringBuffer sb = new StringBuffer();
    }
}
