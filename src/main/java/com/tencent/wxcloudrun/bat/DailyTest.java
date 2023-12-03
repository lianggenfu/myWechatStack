package com.tencent.wxcloudrun.bat;

import java.util.concurrent.ConcurrentHashMap;

public class DailyTest {


    public static void main(String[] args) {

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("a",null);
        concurrentHashMap.put("b","b");

        concurrentHashMap.get("a");

        int result = getReslt();
        System.out.println(result);
    }

    private static int getReslt() {
        int a = 10;
        try {
            a = a/0;
        }catch (Exception e){
            a = 20;
            return a;
        }finally {
            a =30;
            //return a;
        }
        return a;
    }
}
