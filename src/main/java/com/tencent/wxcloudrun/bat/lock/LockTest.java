package com.tencent.wxcloudrun.bat.lock;


import java.util.concurrent.locks.ReentrantLock;

/*
* Lock锁学习
*
* */
public class LockTest implements Runnable{

    private ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread("t1");
        t1.start();

        Thread t2 = new Thread("t2");
        t2.start();

        System.out.println("over !");
    }

    public synchronized void method1(){
        System.out.println("method 1");
    }

    public void method2(){
        try{
            reentrantLock.lock();
            System.out.println("method 2");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }
        System.out.println("method 1");
    }

    @Override
    public void run() {
        method1();
        method2();
    }
}
