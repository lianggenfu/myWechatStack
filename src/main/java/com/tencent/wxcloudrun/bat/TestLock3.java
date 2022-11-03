package com.tencent.wxcloudrun.bat;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock3 implements Runnable{

    private int ticket = 10;

    private final ReentrantLock lock = new ReentrantLock();


    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            try {
                if(ticket > 0){
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
