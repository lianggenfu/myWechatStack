package com.tencent.wxcloudrun.bat;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock2 implements Runnable{

    private int ticket = 100;

    private final ReentrantLock lock = new ReentrantLock();


    @Override
    public void run() {
        while (true){
            lock.lock();
            try {
                if(ticket > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+ " 买到了票"+ ticket--);

                }else{
                    break;
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
