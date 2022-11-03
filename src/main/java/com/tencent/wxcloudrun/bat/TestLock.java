package com.tencent.wxcloudrun.bat;

public class TestLock {

    public static void main(String[] args) {

        TestLock3 testLock3 = new TestLock3();

        new Thread(testLock3,"jane").start();
        new Thread(testLock3,"marchel").start();
        new Thread(testLock3,"mariy").start();

    }
}
