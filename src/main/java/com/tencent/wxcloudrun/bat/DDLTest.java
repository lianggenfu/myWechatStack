package com.tencent.wxcloudrun.bat;

public class DDLTest {

    private volatile static DDLTest instance;

    public DDLTest() {
    }

    public static DDLTest getInstance() {
        if(null == instance){
            synchronized (DDLTest.class){
                if(null == instance) {
                    instance = new DDLTest();
                }
            }
        }
        return instance;
    }
}
