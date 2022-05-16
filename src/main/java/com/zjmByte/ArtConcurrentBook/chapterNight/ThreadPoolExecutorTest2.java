package com.zjmByte.ArtConcurrentBook.chapterNight;

import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest2 {

    static ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 30,
            TimeUnit.MICROSECONDS,
            new LinkedBlockingDeque<Runnable>(2),
            new ThreadPoolExecutor.DiscardOldestPolicy());

    public static void main(String[] args) {
        for (int i = 1; i < 7; i++) {
            System.out.println("添加第"+i+"个任务");
            executor.execute(new MyThread("任务"+i));
            Iterator iterator = executor.getQueue().iterator();
            while (iterator.hasNext()){
                MyThread thread = (MyThread) iterator.next();
                System.out.println("列表："+thread.name);
            }
        }
    }
    static class MyThread implements Runnable {
        String name;
        public MyThread(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程:"+Thread.currentThread().getName() +" 执行:"+name +"  run");
        }
    }
}
