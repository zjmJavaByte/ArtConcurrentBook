package com.zjmByte.ArtConcurrentBook.chapterNight;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {


    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,10,5000L, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(1));


    public static void main(String[] args) {

        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {

            }
        });

        threadPoolExecutor.execute(()->{

        });


        Future<?> submit = threadPoolExecutor.submit(() -> {

        });

        try {
            submit.get();
        }catch (Exception e){

        }finally {
            threadPoolExecutor.shutdown();
        }
        System.out.println(Runtime.getRuntime().availableProcessors());

        ExecutorService executorService = Executors.newCachedThreadPool();


        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(() -> {

        }, 1, 2, TimeUnit.SECONDS);
        ScheduledExecutorService scheduledExecutorService1 = Executors.newSingleThreadScheduledExecutor();

    }

}
